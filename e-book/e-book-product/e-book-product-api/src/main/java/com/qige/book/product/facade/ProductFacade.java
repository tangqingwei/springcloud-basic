package com.qige.book.product.facade;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.qige.book.product.domain.Product;

@RequestMapping(value="/product")
public interface ProductFacade {

	@ResponseBody
	@RequestMapping(value="/list", method=RequestMethod.GET ,produces = "application/json;charset=UTF-8")
	List<Product> listProducts();
	
	@RequestMapping(value="/get", method=RequestMethod.GET)
	Product getProduct(@RequestParam("id") Integer id);
}
