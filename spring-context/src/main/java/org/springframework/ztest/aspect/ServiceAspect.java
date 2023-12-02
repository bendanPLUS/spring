package org.springframework.ztest.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

	@Pointcut("execution(public * org.springframework.ztest.aspect.service.*.*(..))")
	public void pointcut() {
	}


	@Before("pointcut()")
	public void beforePrint(JoinPoint joinPoint) {
		System.out.println("Service Aspect before advice run ......");
	}

	@After("pointcut()")
	public void afterPrint() {
		System.out.println("Service Aspect After advice run ......");
	}

	//@Around("pointcut()")
	public void aroundPrint(JoinPoint joinPoint) {
		System.out.println("Service Aspect Around advice run ......");
	}
}
