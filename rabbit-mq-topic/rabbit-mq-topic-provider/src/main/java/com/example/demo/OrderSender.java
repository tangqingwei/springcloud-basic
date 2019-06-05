package com.example.demo;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrderSender {

	@Autowired
	private AmqpTemplate rabbiTemplate;
	
	@Value("${mq.config.exchange}")
	private String exchange;
	
	//log.info.routing.key
	public void send() {
		String msg = "hello" + new Date();
		this.rabbiTemplate.convertAndSend(this.exchange, "order.log.debug", "order.log.debug.................");
		this.rabbiTemplate.convertAndSend(this.exchange, "order.log.info", "order.log.info.................");
		this.rabbiTemplate.convertAndSend(this.exchange, "order.log.error", "order.log.error.................");
		this.rabbiTemplate.convertAndSend(this.exchange, "order.log.warn", "order.log.warn.................");
	}
}
