package com.qige.book.user.facade;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.qige.book.user.service.UserService;


@RestController
public class UserFacadeImpl implements UserFacade {

	@Autowired
	private UserService userService;
	
	@Override
	public Integer login(String username, String password) {
		return userService.login();
	}

	
}
