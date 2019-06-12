package com.qige.book.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface IReceiveService {

	@Input("qige-exchange")
	SubscribableChannel receive();
}
