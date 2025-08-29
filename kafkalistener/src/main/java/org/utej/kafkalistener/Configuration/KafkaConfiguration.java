package org.utej.kafkalistener.Configuration;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.utej.kafkalistener.Variables;

@Configuration
public class KafkaConfiguration {

    @KafkaListener(topics = Variables.topicName, groupId = Variables.groupId)
    public void listen(String value){
        System.out.println(value);
    }

}
