package com.qige.book.consumer.hystrix;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.qige.book.consumer.service.ProductService;
import com.qige.book.product.domain.Product;

import feign.hystrix.FallbackFactory;

@Component
public class ProductServiceFallbackFactory implements FallbackFactory<ProductService> {
	
	private Logger logger = LoggerFactory.getLogger(ProductServiceFallbackFactory.class);

	@Override
	public ProductService create(final Throwable cause) {
		
		return new ProductService() {
			
			@Override
			public List<Product> listProducts() {
				logger.warn("fallback exection", cause);
				List<Product> list = new ArrayList<Product>();
				list.add(new Product(-1, "fallback"));
				return list;
			}
		};
	}

}
