package com.qige.eureka.consumer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import com.qige.eureka.consumer.domain.Product;

@Service
public class ProductService {

	@Autowired
	private LoadBalancerClient loadBalancerClient;//ribbon负载均衡客户端
	
	@HystrixCommand(fallbackMethod = "fallback",
			commandProperties = {
					//默认10秒；如果并发数达到该设置值，请求会被拒绝和抛出异常并且fallback不会被调用
					//HystrixPropertiesManager.FALLBACK_ISOLATION_SEMAPHORE_MAX_CONCURRENT_REQUESTS
					//设置超时时间为9秒
					@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="9000"),
					//默认20个；10秒内请求数大于20个时就启动熔断器，当请求符合熔断条件时将触发getFallback()
					@HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD, value="10"),
					//请求错误率大于50%时就熔断，然后for循环发起请求，当请求符合熔断条件时将触发getFallback()
					@HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE, value="50"),
					//默认5秒，熔断多少秒后去尝试
					@HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS, value="5000")
			}
			)
	public List<Product> listProducts(Integer n){
		System.out.println(n);
		if (n == 1) {
			throw new RuntimeException();
		}
		ServiceInstance si = loadBalancerClient.choose("e-book-product");
		StringBuffer sb = new StringBuffer("");
		sb.append("http://");
		sb.append(si.getHost());
		sb.append(":");
		sb.append(si.getPort());
		sb.append("/product/list");
		System.out.println(sb.toString());
		RestTemplate restTemplate = new RestTemplate();
		ParameterizedTypeReference<List<Product>> typeRef = new ParameterizedTypeReference<List<Product>>(){};
		ResponseEntity<List<Product>> resp = restTemplate.exchange(sb.toString(), HttpMethod.GET, null, typeRef);
		List<Product> pList = resp.getBody();
		return pList;
	}
	
	public List<Product> fallback(Integer n){
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(-1, "fallback"));
		return list;
	}
}
