package com.demo.rest;

import java.io.IOException;

import jakarta.annotation.Resource;
import jakarta.jms.Connection;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSException;
import jakarta.jms.MessageProducer;
import jakarta.jms.Queue;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/servlet")
public class SendMessageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Resource(lookup = "jms/libertyQCF")
    ConnectionFactory jmsFactory;

    @Resource(lookup = "jms/HelloQueue")
    Queue jmsQueue;

    Connection connection;
    Session session;
    MessageProducer producer;

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String text = req.getParameter("text") != null ? req.getParameter("text") : "Hello World";
        try {
            this.connection = jmsFactory.createConnection();
            this.session = connection.createSession();
            this.producer = session.createProducer(jmsQueue);

            connection.start();

            TextMessage message = session.createTextMessage(text);
            producer.send(message);
        } catch (JMSException e) {
            res.getWriter()
                    .println("Error while trying to send <" + text + "> message: " + e.getMessage());
        }
        res.getWriter().println("Message sent: " + text);
        System.out.println("Message sent: " + text);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
