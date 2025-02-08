package com.example.microservice2.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {
	
	private static final Logger logger = LoggerFactory.getLogger(MessageProducer.class);
	
    @Autowired
    private JmsTemplate jmsTemplate;

    private  String queueName;
    
    @Autowired
    public MessageProducer(JmsTemplate jmsTemplate, @Value("${activemq.response.queue.name}") String queueName) {
        this.jmsTemplate = jmsTemplate;
        this.queueName = queueName;
    }
    public void sendMessage(String message) {
    	logger.info("*****  resposne queue name ****"+queueName);
        jmsTemplate.convertAndSend("response-queue", message);
    }
}
