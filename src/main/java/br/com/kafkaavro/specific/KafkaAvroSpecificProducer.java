package br.com.kafkaavro.specific;

import static io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG;

import br.com.kafkaavro.SpecificItem;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaAvroSpecificProducer implements AutoCloseable {

  private static final String TOPIC = "avro.items.specific";

  private final Producer<String, SpecificItem> producer;

  KafkaAvroSpecificProducer(Producer<String, SpecificItem> producer) {
    this.producer = producer;
  }

  private static Producer<String, SpecificItem> createProducer() {
    Properties props = new Properties();
    props.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    props.put(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

    //properties for schema-registry
    props.put(VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
    props.put(SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");

    return new KafkaProducer<>(props);
  }

  private void send(SpecificItem item) {
    ProducerRecord<String, SpecificItem> record = new ProducerRecord<>(TOPIC, item);
    try {
      producer.send(record);
    } catch (SerializationException e) {
      // handle error
    }
  }

  public static void main(String[] args) {
    try(KafkaAvroSpecificProducer avroProducer = new KafkaAvroSpecificProducer(createProducer())) {

      avroProducer.send(new SpecificItem("Bola", "para futebol", 23L, 20.3d));
      avroProducer.send(new SpecificItem("Bicicleta", "para offroad", 33L, 3928d));
    }
  }

  @Override
  public void close() {
    this.producer.close();
  }
}
