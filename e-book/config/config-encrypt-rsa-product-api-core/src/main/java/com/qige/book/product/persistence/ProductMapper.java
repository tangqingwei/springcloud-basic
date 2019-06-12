package com.qige.book.product.persistence;

import java.util.List;

import com.qige.book.product.domain.Product;

public interface ProductMapper {

	List<Product> findAll();
}
