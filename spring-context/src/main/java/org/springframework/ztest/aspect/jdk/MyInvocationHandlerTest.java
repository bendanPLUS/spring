package org.springframework.ztest.aspect.jdk;

import org.springframework.ztest.aspect.service.UserService;
import org.springframework.ztest.aspect.service.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk的动态代理 必须要实现InvocationHandler接口,重写invoke()方法
 * {@link org.springframework.aop.framework.JdkDynamicAopProxy}
 */
public class MyInvocationHandlerTest implements InvocationHandler {

	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();
		MyInvocationHandlerTest myInvocationHandler = new MyInvocationHandlerTest(userService);
		UserService proxy = (UserService) myInvocationHandler.getProxy();
		proxy.add();
	}

	private Object target;

	public MyInvocationHandlerTest(Object target) {
		super();
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println("-----------JDK before--------------");
		Object result = method.invoke(target, args);
		System.out.println("------------JDK after--------------");
		return result;
	}

	public Object getProxy() {
		return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader()
				, target.getClass().getInterfaces(), this);
	}
}
