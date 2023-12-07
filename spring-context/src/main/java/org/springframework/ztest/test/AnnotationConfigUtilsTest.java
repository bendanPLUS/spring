package org.springframework.ztest.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigUtils;

import java.util.stream.Stream;

public class AnnotationConfigUtilsTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		// 向容器注册了一组基础设施PostProcessor
		// 作用于BeanDefinitionRegistry(容器级)的BeanDefinitionRegistryPostProcessor : 1.ConfigurationClassPostProcessor
		// 作用于BeanFactory(容器级)的BeanFactoryPostProcessor: 3.EventListenerMethodProcessor
		// 一个factory: 4.DefaultEventListenerFactory
		// 一般bean级别的BeanPostProcessor : 1.AutowiredAnnotationBeanPostProcessor 2.CommonAnnotationBeanPostProcessor
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
