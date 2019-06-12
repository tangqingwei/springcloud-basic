package com.qige.book.stream;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@EnableBinding({IReceiveService.class})
public class ReceiveService {

	@StreamListener("qige-exchange")
	public void onReceive(byte[] msg) {
		System.out.println("receive:" + new String(msg));
	}
}
