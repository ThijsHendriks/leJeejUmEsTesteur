package nl.thijs.hendriks.jeejumeskaraoke;


import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author pthomas3
 */
public class QueueConsumer {

    private final Connection connection;
    private final MessageConsumer consumer;
    private final Session session;

    public QueueConsumer(String queueName) {
        this.connection = QueueUtils.getConnection();
        try {
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(queueName);
            consumer = session.createConsumer(destination);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String waitForNextMessage() {
        try {
            TextMessage tm = (TextMessage) consumer.receive();
            return tm.getText();
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

    public void stop() {
        try {
            consumer.close();
            session.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}