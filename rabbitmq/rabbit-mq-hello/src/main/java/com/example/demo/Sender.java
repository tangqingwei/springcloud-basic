package com.example.demo;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {

	@Autowired
	private AmqpTemplate rabbiTemplate;
	
	public void send() {
		String msg = "hello" + new Date();
		this.rabbiTemplate.convertAndSend("hello-qige-queue", msg);
		
	}
}
