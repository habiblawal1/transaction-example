package com.demo.rest;

import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;

@MessageDriven(mappedName = "jms/HelloQueue")
public class ReadMessageMDB implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            TextMessage textMessage = (TextMessage) message;
            System.out.println("Message received by MDB: " + textMessage.getText());
        } catch (JMSException e) {
            System.out.println(
                    "Error while trying to consume messages: " + e.getMessage());
        }
    }
}
