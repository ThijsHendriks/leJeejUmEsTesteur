package nl.thijs.hendriks.jeejumeskaraoke;

import javax.jms.Connection;

import org.apache.activemq.ActiveMQConnectionFactory;

public class QueueUtils {

	private static final Connection connection;

    public static Connection getConnection() {
        return connection;
    }        

    static {
        try {
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
            connection = connectionFactory.createConnection();
            connection.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
