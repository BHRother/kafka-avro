## Kafka + Apache Avro example project

### What is needed?
- Maven
- Java 18+
- Docker
- Docker Compose

### Preparations to run the project

Run the following command:
```
mvn clean compile
```
This will generate the avro schema.

#### How to run the necessary containers
`docker-compose up` - wil setup your zookeeper + kafka + service registry

To access it from outside the container, we need to set the host `kafka-avro` to localhost.

On Mac/Linux:
- `vim /etc/hosts` and add `127.0.0.1 kafka-avro` in the end

On Windows:
- Edit `C:\windows\system32\drivers\etc` host file and add `127.0.0.1 kafka-avro`

### Running the project
There are two versions:
- Generic
- Specific

Both versions have their own producer/consumer.
