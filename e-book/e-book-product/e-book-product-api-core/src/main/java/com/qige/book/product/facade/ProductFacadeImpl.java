package com.qige.book.product.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qige.book.product.domain.Product;

@RestController
public class ProductFacadeImpl implements ProductFacade {

	@Override
	public List<Product> listProducts() {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "基础篇"));
		list.add(new Product(2, "进阶篇"));
		list.add(new Product(3, "高级篇"));
		return list;
	}

	@Override
	public Product getProduct(@RequestParam Integer id) {
		return new Product(id, "进阶篇");
	}
}
