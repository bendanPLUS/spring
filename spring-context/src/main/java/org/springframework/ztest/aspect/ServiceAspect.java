package org.springframework.ztest.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

	@Pointcut("execution(public * org.springframework.ztest.aspect.service.*.*(..))")
	public void pointcut切入点方法() {
	}

	@Before("pointcut切入点方法()") // 一个通知方法+注解上的切入点方法相当于一个增强器(Advisor=一个切入点方法+一个通知方法)
	public void beforePrint通知方法(JoinPoint joinPoint) {
		System.out.println("Service Aspect before advice run ......");
	}

	@After("pointcut切入点方法()")  //一个通知方法+注解上的切入点方法相当于一个增强器
	public void afterPrint通知方法() {
		System.out.println("Service Aspect After advice run ......");
	}

	//@Around("pointcut()") //一个通知方法+注解上的切入点方法相当于一个增强器
	public void aroundPrint(JoinPoint joinPoint) {
		System.out.println("Service Aspect Around advice run ......");
	}
}
