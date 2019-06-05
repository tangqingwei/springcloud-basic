package com.qige.eureka.consumer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.qige.eureka.consumer.domain.Product;

@Service
public class ProductService {

	@Autowired
	private LoadBalancerClient loadBalancerClient;//ribbon负载均衡客户端
	
	public List<Product> listProducts(){
		ServiceInstance si = loadBalancerClient.choose("eureka-provider");
		StringBuffer sb = new StringBuffer("");
		sb.append("http://");
		sb.append(si.getHost());
		sb.append(":");
		sb.append(si.getPort());
		sb.append("/list");
		System.out.println(sb.toString());
		RestTemplate restTemplate = new RestTemplate();
		ParameterizedTypeReference<List<Product>> typeRef = new ParameterizedTypeReference<List<Product>>(){};
		ResponseEntity<List<Product>> resp = restTemplate.exchange(sb.toString(), HttpMethod.GET, null, typeRef);
		List<Product> pList = resp.getBody();
		return pList;
	}
}
