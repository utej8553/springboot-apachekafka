package org.utej.kafkademo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.utej.kafkademo.Service.KafkaService;

@RestController
@RequestMapping("/api")
public class KafkaController {

    @Autowired
    private KafkaService kafkaService;
    @PostMapping("/send")
    public ResponseEntity<?> SendMessage(){
        this.kafkaService.sendMessage("Kafka is working!");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
