package io.krmcbride.hexample.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaConfig {
    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("topic1")
            .partitions(10)
            .replicas(3)
            .build();
    }
}
