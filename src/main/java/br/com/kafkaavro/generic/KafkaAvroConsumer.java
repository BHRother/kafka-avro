package br.com.kafkaavro.generic;

import static io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG;

import br.com.kafkaavro.generic.model.Item;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import java.util.List;
import java.util.Properties;
import org.apache.avro.generic.GenericData.Record;
import org.apache.avro.util.Utf8;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaAvroConsumer implements AutoCloseable {

  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaAvroConsumer.class);

  private static final String TOPIC = "avro.items";

  private final Consumer<String, Object> consumer;

  KafkaAvroConsumer(
      Consumer<String, Object> consumer) {
    this.consumer = consumer;
  }

  private static Consumer<String, Object> createConsumer() {
    Properties props = new Properties();
    props.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    props.put(GROUP_ID_CONFIG, "example");
    props.put(KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");

    // for Avro
    props.put(VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
    props.put(SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");

    return new KafkaConsumer<>(props);
  }

  public void consume() {
    consumer.subscribe(List.of(TOPIC));
    while (true) {
      try {
        ConsumerRecords<String, Object> records = consumer.poll(1000);
        records.forEach(this::processRecord);
      } catch (Exception e) {
        LOGGER.error("Error consuming:: {}", e.getMessage(), e);
      }
    }
  }

  private void processRecord(ConsumerRecord<String, Object> record) {
    Record value = (Record) record.value();
    Item item = parseItem(value);

    LOGGER.info("Processed item:: {}", item);
  }

  private Item parseItem(Record record) {
    return new Item(
        ((Utf8) record.get("name")).toString(),
        ((Utf8) record.get("description")).toString(),
        (Long) record.get("sku"),
        (Double) record.get("price"));
  }

  public static void main(String[] args) {
    try(KafkaAvroConsumer avroConsumer = new KafkaAvroConsumer(createConsumer())) {
      avroConsumer.consume();
    }
  }

  @Override
  public void close() {
    this.consumer.close();
  }
}
