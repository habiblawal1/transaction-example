package com.demo.rest;

import jakarta.annotation.Resource;
import jakarta.ejb.MessageDriven;
import jakarta.ejb.MessageDrivenContext;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;
import jakarta.transaction.Transactional;
import jakarta.ejb.Stateless;

// @MessageDriven(mappedName = "jms/TestQueue")
@Stateless
public class MyBean {
    // @Resource
    // MessageDrivenContext messageDrivenContext;

    // public void onMessage(Message message) {
    // try {
    // if (message instanceof TextMessage) {
    // TextMessage msg = (TextMessage) message;
    // msg.getText();
    // }
    // } catch (JMSException e) {
    // messageDrivenContext.setRollbackOnly();
    // }
    // }
    // Method to send a message
    public void sendMessage(String message) {
        // Code to send message
        System.out.println("Message sent: " + message);
    }
}
