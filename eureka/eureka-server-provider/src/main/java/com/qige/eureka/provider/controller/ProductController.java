package com.qige.eureka.provider.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qige.eureka.provider.domain.Product;

@RestController
public class ProductController {

	@ResponseBody
	@RequestMapping(value="/list", method=RequestMethod.GET ,produces = "application/json;charset=UTF-8")
	public List<Product> listProducts() {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "基础篇"));
		list.add(new Product(2, "进阶篇"));
		list.add(new Product(3, "高级篇"));
		return list;
	}
}
