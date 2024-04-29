package com.demo.rest;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;
import jakarta.ejb.MessageDriven;
import jakarta.ejb.ActivationConfigProperty;

@MessageDriven
public class ReadMessageMDB implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            TextMessage textMessage = (TextMessage) message;
            String incomingTextMessage = textMessage.getText();
            System.out.println("-- a new message arrived: " + incomingTextMessage);
            System.out.println("Message received: " + textMessage.getText());
        } catch (JMSException e) {
            System.out.println(
                    "Error while trying to consume messages: " + e.getMessage());
        }
    }
}
