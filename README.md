# Spring Boot Apache Kafka Demo

## Overview

This repository demonstrates a simple Spring Boot application integrated with Apache Kafka. It contains:

- **Producer application (`kafkademo`)**: Sends messages to a Kafka topic.  
- **Consumer application (`kafkalistener`)**: Listens to the Kafka topic and prints messages.  
- Basic Kafka configuration using Spring Boot.  

This project is a starting point for building real-time messaging pipelines with Spring Boot and Kafka.

---

## What is Apache Kafka?

Apache Kafka is a distributed streaming platform used to:

- Publish messages (**produce**) to topics.  
- Subscribe to messages (**consume**) from topics.  
- Store messages durably and fault-tolerantly.  
- Process data streams in real-time.  

Kafka is widely used in event-driven architectures, real-time analytics, and microservices communication.

---

## Project Workflow

The workflow of this project:

1. **Start Zookeeper** – Kafka broker coordinator.  
2. **Start Kafka Broker** – Manages topics and stores messages.  
3. **Send messages** via Spring Boot producer or console producer.  
4. **Receive messages** via Spring Boot consumer or console consumer.  

---

## Project Structure

### Producer Side (`kafkademo`)

- **KafkaConfiguration.java** – Configures topic creation.
```java
@Bean
public NewTopic topic() {
    return TopicBuilder.name(Variables.topicName).build();
}
```
er.auto-offset-reset=earliest to read messages sent before the consumer started.
