package com.example.microservice2.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
	
	private static final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);
	  @Autowired
	  private MessageProducer messageProducer;
	  
	  @JmsListener(destination = "queue.microservice1.delete")
    
    public void receiveMessage(String message) {
    	logger.info("Message received from activemq queue---"+message);
    	messageProducer.sendMessage("Resonse recived for program deletion");
    }
}
