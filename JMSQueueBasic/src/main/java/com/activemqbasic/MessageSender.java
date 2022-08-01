package com.activemqbasic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageSender {

    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;//pointing to default JMS server url
    private static String queueName = "MESSAGE_QUEUE";//queue name for JMS

    public static void main(String[] args) throws JMSException {
        System.out.println("URL is "+url);
        //Get connection from JMS server and start it
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();

        //create non transactional session to send/receive message
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //queue automatically created on server
        Destination destination = session.createQueue(queueName);

        //Message producer to send message to queue
        MessageProducer producer = session.createProducer(destination);
        TextMessage message = session.createTextMessage("Hello World!");
        producer.send(message);

        System.out.println("Message "+message.getText()+" sent successfully to Queue");
        connection.close();
    }

}
