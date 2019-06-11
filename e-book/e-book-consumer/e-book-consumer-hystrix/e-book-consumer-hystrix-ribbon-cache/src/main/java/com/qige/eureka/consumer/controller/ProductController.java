package com.qige.eureka.consumer.controller;

import java.util.List;

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
	
	@RequestMapping(value="/list", method=RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public List<Product> listProducts(){
		List<Product> list = productService.listProducts();
		return list;
	}
	
	@RequestMapping(value="/get", method=RequestMethod.GET)
	public Product get(Integer id) {
		return productService.get(id);
	}
	
	@RequestMapping(value="/del", method=RequestMethod.GET)
	public void del(Integer id) {
		productService.del(id);
	}
}
