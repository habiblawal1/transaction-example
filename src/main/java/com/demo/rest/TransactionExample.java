//package com.demo.rest;
//
//import jakarta.annotation.Resource;
//import jakarta.enterprise.context.ApplicationScoped;
//import jakarta.inject.Inject;
//import jakarta.jms.JMSContext;
//import jakarta.jms.Queue;
//import jakarta.transaction.Transactional;
//
//@ApplicationScoped
//public class TransactionExample {
//
//    @Inject
//    private JMSContext jmsContext;
//
//    @Resource(lookup = "jms/libertyQue")
//    private Queue queue;
//
//    @Transactional
//    public void sendMessageWithTransaction(String message) {
//        jmsContext.createProducer().send(queue, message);
//    }
//
//    public void sendMessageWithoutTransaction(String message) {
//        jmsContext.createProducer().send(queue, message);
//    }
//}
