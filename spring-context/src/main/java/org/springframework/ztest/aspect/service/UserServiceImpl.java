package org.springframework.ztest.aspect.service;

import org.springframework.ztest.aspect.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public void add() {
		System.out.println("------------add--------------");
	}
}
