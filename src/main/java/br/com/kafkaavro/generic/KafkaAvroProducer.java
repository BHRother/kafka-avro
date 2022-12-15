package br.com.kafkaavro.generic;

import static io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG;

import br.com.kafkaavro.generic.model.Item;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import java.util.Properties;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaAvroProducer implements AutoCloseable {

  private static final String TOPIC = "avro.items";

  private final Producer<String, Object> producer;

  KafkaAvroProducer(Producer<String, Object> producer) {
    this.producer = producer;
  }

  private static Producer<String, Object> createProducer() {
    Properties props = new Properties();
    props.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    props.put(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    //serialise as String / JSON
    //props.put(VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

    //properties for schema-registry
    props.put(VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
    props.put(SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");

    return new KafkaProducer<>(props);
  }

  private Schema createSchema() {
    //language=JSON
    String userSchema = "{\"type\":\"record\",\n" +
        "  \"name\":\"item\",\n" +
        "  \"fields\":[\n" +
        "    {\"name\":\"name\",\"type\":\"string\"},\n" +
        "    {\"name\":\"description\",\"type\":\"string\"},\n" +
        "    {\"name\":\"sku\",\"type\":\"long\"},\n" +
        "    {\"name\":\"price\",\"type\":\"double\"}\n" +
        "  ]}";
    Schema.Parser parser = new Schema.Parser();
    return parser.parse(userSchema);
  }

  private void send(Item item) {
    GenericRecord avroRecord = createAvroRecord(item);
    ProducerRecord<String, Object> record = new ProducerRecord<>(TOPIC, avroRecord);
    try {
      producer.send(record);
    } catch (SerializationException e) {
      // handle error
    }
  }

  private GenericRecord createAvroRecord(Item item) {
    final GenericRecord record = new GenericData.Record(createSchema());
    record.put("name", item.getName());
    record.put("description", item.getDescription());
    record.put("sku", item.getSku());
    record.put("price", item.getPrice());
    return record;
  }

  public static void main(String[] args) {
    try(KafkaAvroProducer avroProducer = new KafkaAvroProducer(createProducer())) {

      avroProducer.send(new Item("Bola", "para futebol", 23L, 20.3d));
      avroProducer.send(new Item("Bicicleta", "para offroad", 33L, 3928d));
    }
  }

  @Override
  public void close() {
    this.producer.close();
  }
}
