package com.qige.book.consumer.service;


import org.springframework.cloud.openfeign.FeignClient;
import com.qige.book.product.facade.ProductFacade;


@FeignClient(name="e-book-product")
public interface ProductService extends ProductFacade{

	
}
