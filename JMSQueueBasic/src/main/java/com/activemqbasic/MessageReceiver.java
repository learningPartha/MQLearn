package com.activemqbasic;


import javax.jms.*;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageReceiver {

    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;//pointing to default JMS server url
    private static String queueName = "MESSAGE_QUEUE";//queue name for JMS

    public static void main (String[] args) throws JMSException{

        System.out.println("URL is "+url);
        //Get connection from JMS server and start it
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();

        //create non transactional session to send/receive message
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //queue automatically created on server
        Destination destination = session.createQueue(queueName);

        //Message consumer to receive message from queue
        MessageConsumer consumer = session.createConsumer(destination);
        Message message = consumer.receive();

        if (message instanceof TextMessage)
        {
            TextMessage textMessage = (TextMessage) message;
            System.out.println("Received message '" + textMessage.getText() + "'");
        }
        connection.close();

    }
}
