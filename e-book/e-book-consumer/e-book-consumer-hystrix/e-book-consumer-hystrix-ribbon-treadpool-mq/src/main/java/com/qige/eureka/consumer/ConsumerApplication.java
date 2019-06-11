package com.qige.eureka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;


@EnableCircuitBreaker // 开启服务降级的断路器
@EnableEurekaClient
@SpringBootApplication
@EnableHystrix
public class ConsumerApplication {

//	@Bean
//	public ServletRegistrationBean getServlet() {
//
//		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
//		ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
//		registrationBean.setLoadOnStartup(1); // 系统启动时加载顺序
//		registrationBean.addUrlMappings("/hystrix.stream");// 路径
//		registrationBean.setName("HystrixMetricsStreamServlet");
//		return registrationBean;
//	}

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

}
