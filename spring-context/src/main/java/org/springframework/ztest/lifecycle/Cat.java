package org.springframework.ztest.lifecycle;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.SmartLifecycle;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@DependsOn("factoryBeanDemo")
public class Cat implements InitializingBean, SmartInitializingSingleton, SmartLifecycle {

	@Autowired
	Person person;

	public Cat() {
		System.out.println("Cat 类的构造方法");
	}

	@PostConstruct
	private void postConstruct() {
		System.out.println("Cat 先执行 利用@PostConstruct注解");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Cat 后执行 实现InitializingBean接口重写afterPropertiesSet()方法 进行初始化");
	}

	// 需要方法@ Bean注解注入时设置 (initMethod = "init", destroyMethod = "destroy")
	public void init() {
		System.out.println("Cat 实现init()方法 进行初始化");
	}

	public void destroy() {
		System.out.println("销毁Cat对象 执行destroy()方法");
	}

	@Override
	public void afterSingletonsInstantiated() {
		// 给所有对象 提供一个统一回调的时机
		System.out.println("此时Cat对象已经创建完成, 为单例非延迟对象创建完成后 , 预留的统一的扩展点(重写SmartInitializingSingleton接口afterSingletonsInstantiated方法)");
	}

	@Override
	public void start() {
		System.out.println("触发Lifecycle生命周期处理器 Cat start方法");
	}

	@Override
	public void stop() {
		System.out.println("触发Lifecycle生命周期处理器 Cat stop方法");
	}

	@Override
	public boolean isRunning() {
		return false;
	}

}
