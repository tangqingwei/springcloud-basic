package com.qige.book.consumer.hystrix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.qige.book.consumer.service.ProductService;
import com.qige.book.product.domain.Product;

@Component
public class ProductServiceFallback implements ProductService {

	@Override
	public List<Product> listProducts() {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(-1, "fallback"));
		return list;
	}

}
