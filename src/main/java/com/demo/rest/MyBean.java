//package com.demo.rest;
//
//import jakarta.annotation.Resource;
//import jakarta.ejb.MessageDriven;
//import jakarta.ejb.MessageDrivenContext;
//import jakarta.jms.JMSException;
//import jakarta.jms.Message;
//import jakarta.jms.MessageListener;
//import jakarta.jms.TextMessage;
//
//@MessageDriven(mappedName = "jms/TestQueue")
//public class MyBean implements MessageListener {
//    @Resource
//    MessageDrivenContext messageDrivenContext;
//
//    public void onMessage(Message message) {
//        try {
//            if (message instanceof TextMessage) {
//                TextMessage msg = (TextMessage) message;
//                msg.getText();
//            }
//        } catch (JMSException e) {
//            messageDrivenContext.setRollbackOnly();
//        }
//    }
//}
