package nl.thijs.hendriks.lejeejumestesteur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeController {

	@Autowired
	private JmsTemplate jmsTemplate;

	@GetMapping("/sendemail")
	public String send() {
		jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", "Hello"));
		return "Ok";
	}
}