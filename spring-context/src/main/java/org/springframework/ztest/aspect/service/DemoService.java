package org.springframework.ztest.aspect.service;

import org.springframework.stereotype.Service;

@Service
public class DemoService {

	public void save() {
		System.out.println("DemoService save run ......");
	}
}

