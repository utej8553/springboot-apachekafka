package org.utej.kafkademo.Configuration;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.utej.kafkademo.Variables;

import static ch.qos.logback.classic.spi.ThrowableProxyUtil.build;

@Configuration
public class KafkaConfiguration {
    @Bean
    public NewTopic topic(){
        return TopicBuilder
                .name(Variables.topicName)
                .build();
        //can also mention partitions
        // with replicas
    }
}
