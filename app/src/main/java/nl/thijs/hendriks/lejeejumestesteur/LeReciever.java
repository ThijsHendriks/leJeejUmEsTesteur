package nl.thijs.hendriks.lejeejumestesteur;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class LeReciever {

	@JmsListener(destination = "mailbox", containerFactory = "myFactory")
	public void receiveMessage(String message) {
		System.out.println("Received <" + message + ">");
	}

}
