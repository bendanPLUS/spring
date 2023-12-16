package org.springframework.ztest;

import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.annotation.*;
import org.springframework.core.SimpleAliasRegistry;
import org.springframework.ztest.aspect.service.DemoService;
import org.springframework.ztest.forTestFactoryBean.FactoryBeanDemo;
import org.springframework.ztest.forTestFactoryBean.SubBean;

import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("org.springframework.ztest");
		//Stream.of(ctx.getBeanFactory().getBeanDefinitionNames()).forEach(System.out::println);
		//testTestAlisaTransformedBeanName(ctx);
		//test(ctx);
		testAop(ctx);
		ctx.close();
	}

	public static void testAop(AnnotationConfigApplicationContext ctx) {
		// 本地debug，会在本地生成对应的代理对象文件
		// System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"存放的路径");
		DemoService bean = ctx.getBean(DemoService.class);
		bean.save();
	}

	public static void testTestAlisaTransformedBeanName(AnnotationConfigApplicationContext ctx) {
		System.out.println("Hello world!");

		new AnnotatedBeanDefinitionReader(ctx).register(TestAlisaTransformedBeanName.class);
		ctx.refresh();
		Stream.of(ctx.getBeanFactory().getBeanDefinitionNames()).forEach(System.out::println);
	}

	public static void test(AnnotationConfigApplicationContext ctx) {
		AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader = new AnnotatedBeanDefinitionReader(ctx);
		annotatedBeanDefinitionReader.register(FactoryBeanDemo.class);
		annotatedBeanDefinitionReader.register(SubBean.class);
		ctx.refresh();
		Object subBean = ctx.getBean("factoryBeanDemo");
		System.out.println(subBean);
	}

	//为了别名的解析测试
	@Configuration
	static class TestAlisaTransformedBeanName {
		/**
		 * 别名 默认传入的第一个是BeanName 后面的都是别名 放在别名注册表({@link SimpleAliasRegistry#aliasMap})中
		 * {@link AbstractBeanFactory#doGetBean(String, Class, Object[], boolean)}
		 * {@link AbstractBeanFactory#transformedBeanName(String)}
		 * {@link SimpleAliasRegistry#canonicalName(String)}
		 * {@link SimpleAliasRegistry#aliasMap}
		 */
		//别名 默认传入的第一个是BeanName 后面的都是别名
		@Bean({"u1", "u2", "u3"})
		public User UserOne() {
			return new User("张小三");
		}

		@Bean({"u5", "u6", "u7"})
		public User UserTwo() {
			return new User("张大三");
		}
	}
}
