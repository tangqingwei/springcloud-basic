package com.example.demo;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProductSender {

	@Autowired
	private AmqpTemplate rabbiTemplate;
	
	@Value("${mq.config.exchange}")
	private String exchange;
	
	//log.info.routing.key
	public void send() {
		String msg = "hello" + new Date();
		this.rabbiTemplate.convertAndSend(this.exchange, "product.log.debug", "product.log.debug.................");
		this.rabbiTemplate.convertAndSend(this.exchange, "product.log.info", "product.log.info.................");
		this.rabbiTemplate.convertAndSend(this.exchange, "product.log.error", "product.log.error.................");
		this.rabbiTemplate.convertAndSend(this.exchange, "product.log.warn", "product.log.warn.................");
	}
}
