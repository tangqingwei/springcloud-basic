package com.example.demo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	@RabbitListener(queues="hello-qige-queue")
	public void process(String msg) {
		System.out.println("receiver: " + msg);
	}
}
