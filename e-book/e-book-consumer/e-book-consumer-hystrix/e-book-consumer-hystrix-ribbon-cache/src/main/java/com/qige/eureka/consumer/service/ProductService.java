package com.qige.eureka.consumer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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

@CacheConfig(cacheNames={"com.qige.cache"})
@Service
public class ProductService {

	@Autowired
	private LoadBalancerClient loadBalancerClient;//ribbon负载均衡客户端
	
	@HystrixCommand(fallbackMethod = "fallback",
			commandProperties = {
					//默认10秒；如果并发数达到该设置值，请求会被拒绝和抛出异常并且fallback不会被调用
					//HystrixPropertiesManager.FALLBACK_ISOLATION_SEMAPHORE_MAX_CONCURRENT_REQUESTS
					//设置超时时间为9秒
					@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="9000")
			}
			)
	public List<Product> listProducts(){
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
	
	public List<Product> fallback(){
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(-1, "fallback"));
		return list;
	}
	
	@Cacheable(key="'product' + #id")
	public Product get(Integer id) {
		System.out.println("==============get=============");
		return new Product(id, "Spring cloud 进阶篇");
	}
	
	@CacheEvict(key="'product' + #id")
	public void del(Integer id) {
		System.out.println("==============del=============");
	}
}
