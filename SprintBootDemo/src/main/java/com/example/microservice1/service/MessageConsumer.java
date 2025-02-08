package com.example.microservice1.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
	
	private static final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);
	@JmsListener(destination = "response-queue")
    public void receiveMessage(String message) {
    	logger.info("Message received from response queue---"+message);
    }
}
