package org.springframework;

import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.SimpleAliasRegistry;

import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello world!");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		new AnnotatedBeanDefinitionReader(ctx).register(TestConfiguration.class);
		ctx.refresh();
		Stream.of(ctx.getBeanFactory().getBeanDefinitionNames()).forEach(System.out::println);
	}

	@Configuration
	static class TestConfiguration {
		/**
		 * 别名 默认传入的第一个是name 后面的都是别名 放在别名注册表({@link SimpleAliasRegistry#aliasMap})中
		 * {@link AbstractBeanFactory#doGetBean(String, Class, Object[], boolean)}
		 * {@link AbstractBeanFactory#transformedBeanName(String)}
		 * {@link SimpleAliasRegistry#canonicalName(String)}
		 * {@link SimpleAliasRegistry#aliasMap}
		 */
		@Bean({"u1","u2"})
		public User UserOne() {
			return new User("张小三");
		}

		@Bean({"u5","u6"})
		public User UserTwo() {
			return new User("张大三");
		}
	}
}
