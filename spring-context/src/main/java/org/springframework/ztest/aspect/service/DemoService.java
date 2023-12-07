package org.springframework.ztest.aspect.service;

import org.springframework.stereotype.Service;

@Service
public class DemoService implements UserService{
	public void save() {
		System.out.println("DemoService save run ......");
	}

	@Override
	public void add() {
		System.out.println("DemoService save add ......");
	}
}

