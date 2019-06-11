package com.qige.eureka.consumer.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qige.eureka.consumer.domain.Product;
import com.qige.eureka.consumer.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/get", method=RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public List<Product> get() throws InterruptedException, ExecutionException{
		Future<Product> p1= productService.getProduct(1);
		Future<Product> p2= productService.getProduct(2);
		System.out.println(p1.get().toString());
		System.out.println(p2.get().toString());
		return null;
	}
}
