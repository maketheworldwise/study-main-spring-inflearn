package com.example.application.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Configuration
public class MessageConfig {

    @Bean
    @Order(1)
    MessagePostProcessor indexer() {
        return new MessagePostProcessor() {
            @Override
            public void postProcess(Message message) {
                System.out.println("indexer()");
            }
        };
    }

    @Bean
    @Order(2)
    MessagePostProcessor alarmSender() {
        return new MessagePostProcessor() {
            @Override
            public void postProcess(Message message) {
                System.out.println("alarmSender()");
            }
        };
    }

    static class Message {
    }

    interface MessagePostProcessor {
        void postProcess(Message message);
    }

    @Component
    static class MessageSender {

        @Autowired
        private List<MessagePostProcessor> postProcessorList;

        public void sendMessage() {
            // code for sending message
            Message message = new Message();
            for(MessagePostProcessor postProcessor : postProcessorList) {
                postProcessor.postProcess(message);
            }
        }
    }
}
