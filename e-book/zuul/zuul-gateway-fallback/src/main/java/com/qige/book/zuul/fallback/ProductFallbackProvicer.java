package com.qige.book.zuul.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductFallbackProvicer implements FallbackProvider  {

	public String getRoute() {
		// 代表哪个服务提供fallback
		return "e-book-product";
	}

	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		// TODO Auto-generated method stub
		return new ClientHttpResponse() {
			
			public HttpHeaders getHeaders() {
				// TODO Auto-generated method stub
				HttpHeaders headers = new HttpHeaders();
				MediaType mt = new MediaType("application","json",Charset.forName("UTF-8"));
				headers.setContentType(mt);
				return headers;
			}
			
			public InputStream getBody() throws IOException {
				// 
				String input = "商品服务不可用";
				return new ByteArrayInputStream(input.getBytes());
			}
			
			public String getStatusText() throws IOException {
				// httpresponse的fallback的状态码 string
				return this.getStatusCode().getReasonPhrase();
			}
			
			public HttpStatus getStatusCode() throws IOException {
				// httpresponse的fallback的状态码
				return HttpStatus.OK;
			}
			
			public int getRawStatusCode() throws IOException {
				// TODO Auto-generated method stub
				return this.getStatusCode().value();
			}
			
			public void close() {
				// TODO Auto-generated method stub
				
			}
		};
	}

}
