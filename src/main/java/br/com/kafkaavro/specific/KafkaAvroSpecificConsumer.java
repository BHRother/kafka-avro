package br.com.kafkaavro.specific;

import static io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG;
import static io.confluent.kafka.serializers.KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG;

import br.com.kafkaavro.SpecificItem;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaAvroSpecificConsumer implements AutoCloseable {

  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaAvroSpecificConsumer.class);

  private static final String TOPIC = "avro.items.specific";

  private final Consumer<String, SpecificItem> consumer;

  KafkaAvroSpecificConsumer(
      Consumer<String, SpecificItem> consumer) {
    this.consumer = consumer;
  }

  private static Consumer<String, SpecificItem> createConsumer() {
    Properties props = new Properties();
    props.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    props.put(GROUP_ID_CONFIG, "example");
    props.put(KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");

    // for Avro
    props.put(VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
    props.put(SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");

    // tells avro to read as a specific record type, instead of generic
    props.put(SPECIFIC_AVRO_READER_CONFIG, "true");
    return new KafkaConsumer<>(props);
  }

  public void consume() {
    consumer.subscribe(List.of(TOPIC));
    while (true) {
      try {
        ConsumerRecords<String, SpecificItem> records = consumer.poll(Duration.ofSeconds(1));
        records.forEach(this::processRecord);
      } catch (Exception e) {
        LOGGER.error("Error consuming:: {}", e.getMessage(), e);
      }
    }
  }

  private void processRecord(ConsumerRecord<String, SpecificItem> record) {
    SpecificItem value = record.value();
    LOGGER.info("Processed specific item:: {}", value.toString());
  }

  public static void main(String[] args) {
    try(KafkaAvroSpecificConsumer avroConsumer = new KafkaAvroSpecificConsumer(createConsumer())) {
      avroConsumer.consume();
    }
  }

  @Override
  public void close() {
    this.consumer.close();
  }
}
