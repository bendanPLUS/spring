package org.springframework.ztest.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigUtils;

import java.util.stream.Stream;

public class AnnotationConfigUtilsTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		AnnotationConfigUtils.registerAnnotationConfigProcessors(beanFactory);
		// 以前的写法:
		/** for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}
		 */
		// 现在的写法
		Stream.of(beanFactory.getBeanDefinitionNames()).forEach(System.out::println);
	}
}
