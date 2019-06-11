package com.qige.eureka.consumer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import javax.swing.RowFilter.ComparisonType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import com.qige.eureka.consumer.domain.Product;

@Service
public class ProductService {

	@HystrixCollapser(batchMethod="batchProduct", scope=com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL,
			collapserProperties= {
					//请求时间间隔在50ms之内的请求会合并为一个请求
					@HystrixProperty(name="timerDelayInMilliseconds", value="20"),
					//设置触发批处理执行之前，在批处理中允许的最大请求数
					@HystrixProperty(name="maxRequestsInBatch", value="200")
			}
			)
	public Future<Product> getProduct(Integer id){
		System.out.println("++++++++++++++++++++++++++++++++");
		return null;
	}
	
	@HystrixCommand
	public List<Product> batchProduct(List<Integer> ids){
		System.out.println("------------------------------");
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "基础篇"));
		list.add(new Product(2, "进阶篇"));
		list.add(new Product(3, "高级篇"));
		return list;
	}
}
