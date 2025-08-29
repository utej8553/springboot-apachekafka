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
*   **KafkaService.java** – Sends messages using KafkaTemplate.
    

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   public boolean sendMessage(String message) {      kafkaTemplate.send(Variables.topicName, message);      logger.info(message);      return true;  }   `

*   **KafkaController.java** – REST endpoint to send messages.
    

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   @PostMapping("/send")  public ResponseEntity SendMessage() {      kafkaService.sendMessage("Kafka is working!");      return new ResponseEntity<>(HttpStatus.OK);  }   `

### Consumer Side (kafkalistener)

*   **KafkaConfiguration.java** – Configures a Kafka listener.
    

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   @KafkaListener(topics = Variables.topicName, groupId = Variables.groupId)  public void listen(String value) {      System.out.println(value);  }   `

Running the Project
-------------------

### 1️⃣ Start Zookeeper

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   cd ~/kafka_2.13-3.9.1  bin/zookeeper-server-start.sh config/zookeeper.properties   `

Zookeeper is required for Kafka brokers to manage metadata and leader elections.

### 2️⃣ Start Kafka Broker

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   bin/kafka-server-start.sh config/server.properties   `

Kafka broker handles storing messages and delivering them to consumers.

### 3️⃣ Send Messages

**Option A: Using Kafka Console Producer**

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   bin/kafka-console-producer.sh --topic Demotopic --bootstrap-server localhost:9092   `

Type messages and press Enter to send.

**Option B: Using Spring Boot Producer**

Run the producer application (kafkademo) and trigger the endpoint:

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   POST http://localhost:8080/api/send   `

This sends "Kafka is working!" to the topic Demotopic.

### 4️⃣ Consume Messages

**Option A: Using Kafka Console Consumer**

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   bin/kafka-console-consumer.sh --topic Demotopic --from-beginning --bootstrap-server localhost:9092   `

**Option B: Using Spring Boot Consumer**

Run the consumer application (kafkalistener). It automatically listens to Demotopic and prints messages in real-time.

Important Notes
---------------

*   Ensure topic names match exactly (Demotopic) in producer, consumer, and console commands. Kafka is case-sensitive.
    
*   Spring Boot can auto-create topics if they don’t exist.
    
*   Use spring.kafka.consumer.auto-offset-reset=earliest to read messages sent before the consumer started.
