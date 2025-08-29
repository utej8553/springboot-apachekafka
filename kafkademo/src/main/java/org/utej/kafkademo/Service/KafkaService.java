package org.utej.kafkademo.Service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.utej.kafkademo.Variables;

@Service
public class KafkaService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private Logger logger = LoggerFactory.getLogger(KafkaService.class);
    public boolean sendMessage(String message) {
        this.kafkaTemplate.send(Variables.topicName, message);
        this.logger.info(message);
        return true;
    }
}
