package com.qige.book.sender;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface ISendService {

	String OUTPUT="outputProduct";
	
	@Output(OUTPUT)
	SubscribableChannel send();
}
