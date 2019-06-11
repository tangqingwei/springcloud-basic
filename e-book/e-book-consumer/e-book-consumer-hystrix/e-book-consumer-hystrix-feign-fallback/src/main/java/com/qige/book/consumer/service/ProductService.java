package com.qige.book.consumer.service;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qige.book.consumer.hystrix.ProductServiceFallback;
import com.qige.book.product.domain.Product;


@FeignClient(name="e-book-product", fallback=ProductServiceFallback.class)
public interface ProductService {
	
	@RequestMapping(value="product/list", method=RequestMethod.GET)
	public List<Product> listProducts();
	
}
