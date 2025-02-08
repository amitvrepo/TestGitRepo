package com.example.microservice1.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


@Component
public class MessageProducer {

	private static final Logger logger = LoggerFactory.getLogger(MessageProducer.class);
    private final JmsTemplate jmsTemplate;
    private final String queueName;
    
    @Autowired
    public MessageProducer(JmsTemplate jmsTemplate, @Value("${activemq.queue.name}") String queueName) {
        this.jmsTemplate = jmsTemplate;
        this.queueName = queueName;
    }

    public void sendMessage(String message) {
    	logger.info("****************queueName*************"+queueName);
        jmsTemplate.convertAndSend(queueName, message);
    }
}
