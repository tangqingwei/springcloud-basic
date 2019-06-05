package com.qige.springboot.helloworld.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qige.springboot.helloworld.exception.BussinessException;
/**
 * 
 * @author sqhtech
 *
	@Controller
	@ResponseBody
 */
/**
 * 
 * @ControllerAdvice
 *
 */
@RestController
public class HelloWorldController {

	@Value("${qige.msg}")
	private String msg;
	
	@RequestMapping("/hello")
	public String index() {
//		int no = 1/0;
		throw new BussinessException("100", "用户名密码错误");
//		return this.msg;
//		return "hello world qige";
	}
}
