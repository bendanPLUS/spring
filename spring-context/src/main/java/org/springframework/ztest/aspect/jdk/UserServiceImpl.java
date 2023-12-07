package org.springframework.ztest.aspect.jdk;

public class UserServiceImpl implements UserService{

	@Override
	public void add() {
		System.out.println("------------add--------------");
	}
}
