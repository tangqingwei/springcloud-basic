package com.example.demo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=RabbitMqHelloApplication.class)
public class RabbitMqHelloApplicationTests {

	@Autowired
	private UserSender userSenderender;
	@Autowired
	private ProductSender productSender;
	@Autowired
	private OrderSender orderSender;
	
	@Test
	public void send() throws InterruptedException {
		this.userSenderender.send();
		this.productSender.send();
		this.orderSender.send();
	}

}
