package com.qige.springboot.helloworld.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyControllerAdvice {

	/**
	 * 	全局捕获异常，只要作用在@RequestMapping
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(value=Exception.class)
	public Map<String, Object> errorHandler(Exception ex){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", -1);
		map.put("msg",ex.getMessage());
		return map;
	}
	
	@ResponseBody
	@ExceptionHandler(value=BussinessException.class)
	public Map<String, Object> errorHandler(BussinessException ex){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", ex.getCode());
		map.put("msg",ex.getMsg());
		return map;
	}
}
