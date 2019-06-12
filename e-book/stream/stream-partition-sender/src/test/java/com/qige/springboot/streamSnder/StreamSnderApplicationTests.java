package com.qige.springboot.streamSnder;

import org.apache.tomcat.util.net.AprEndpoint.Sendfile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import com.qige.book.sender.ISendService;
import com.qige.book.sender.Product;
import com.qige.book.sender.StreamSenderApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StreamSenderApplication.class)
public class StreamSnderApplicationTests {

	@Autowired
	private ISendService send;
	
	@Test
	public void send() {
		Product obj = new Product(1, "haha spring cloud");
		for (int i = 0; i < 10; i++) {
			Message message=MessageBuilder.withPayload(obj).build();
			this.send.send().send(message);
		}
	}
	
	@Test
	public void contextLoads() {
	}

}
