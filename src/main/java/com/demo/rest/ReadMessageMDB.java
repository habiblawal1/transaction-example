package com.demo.rest;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;
import jakarta.ejb.MessageDriven;
import jakarta.ejb.ActivationConfigProperty;
import jakarta.jms.Queue;

// @MessageDriven(mappedName = "jms/HelloQueue")
// @MessageDriven(mappedName = "jms/HelloQueue", activationConfig = {
//         @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
//         @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue")
// })
@MessageDriven(mappedName = "jms/HelloQueue", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationName", propertyValue = "jms/HelloQueue"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue") })
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
