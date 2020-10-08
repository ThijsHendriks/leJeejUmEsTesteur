package nl.thijs.hendriks.lejeejumestesteur;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeController {

	@Autowired
	private JmsTemplate jmsTemplate;

	@GetMapping("/sendemail")
	public String send(@RequestParam(name = "message") Optional<String> message) {
		jmsTemplate.convertAndSend("mailbox", message.orElse("Hello"));
		return "Ok";
	}
}