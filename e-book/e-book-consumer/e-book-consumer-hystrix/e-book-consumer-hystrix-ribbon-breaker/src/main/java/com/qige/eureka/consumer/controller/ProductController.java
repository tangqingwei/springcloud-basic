package com.qige.eureka.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qige.eureka.consumer.domain.Product;
import com.qige.eureka.consumer.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public List<Product> listProducts(@RequestParam("n") Integer n){
		List<Product> list = productService.listProducts(n);
		return list;
	}
}
