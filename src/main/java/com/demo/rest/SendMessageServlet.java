package com.demo.rest;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

// import jakarta.naming.Context;
// import jakarta.naming.InitialContext;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.Connection;
import jakarta.jms.Queue;
import jakarta.jms.Session;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.jms.JMSException;
import jakarta.jms.MessageProducer;
import jakarta.jms.TextMessage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/servlet")
public class SendMessageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private MyBean messageSenderBean;

    @Resource(lookup = "jms/libertyQCF")
    ConnectionFactory jmsFactory;

    @Resource(lookup = "jms/libertyQue")
    Queue jmsQueue;

    Connection connection;

    Session session;

    MessageProducer producer;

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // messageSenderBean.sendMessage("Hello, World!");
        // // tag::responsestring[]
        // response.getWriter().append("Message sent successfully!\n");
        // // end::responsestring[]

        String text = req.getParameter("text") != null ? req.getParameter("text") : "Hello World";

        try {
            // Context ic = new InitialContext();

            // ConnectionFactory cf = (ConnectionFactory)
            // ic.lookup("jms/ConnectionFactory");
            // Queue queue = (Queue) ic.lookup("queue/tutorialQueue");

            // Connection connection = cf.createConnection();

            // Session session = connection.createSession(
            // false, Session.AUTO_ACKNOWLEDGE);
            // MessageProducer publisher = session
            // .createProducer(queue);

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

        res.getWriter()
                .println("Message sent: " + text);
        System.out.println("Message sent: " + text);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
