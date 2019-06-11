package com.qige.book.user.facade;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value="/user")
public interface UserFacade {

	@ResponseBody
	@RequestMapping(value="/login", method=RequestMethod.GET ,produces = "application/json;charset=UTF-8")
	public Integer login(@RequestParam("username") String username, @RequestParam("password") String password);
	
}
