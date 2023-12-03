package org.springframework.ztest.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifecycleConfig {
	// 指定init方法 和 destroy方法
	@Bean(initMethod = "init", destroyMethod = "destroy")
	public Cat cat(){
		return new Cat();
	}
}
