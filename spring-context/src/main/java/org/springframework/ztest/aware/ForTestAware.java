package org.springframework.ztest.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ForTestAware implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	/**
	 *  ApplicationContextAwareProcessor初始化的时机:
	 *		项目启动时,refresh方法中,准备beaen工厂,{@link org.springframework.context.support.AbstractApplicationContext#prepareBeanFactory(ConfigurableListableBeanFactory)}
	 *			beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));
	 *  bean实例化前的后置处理器 对于实现Aware相关接口的类,进行Aware处理 重写Set方法
	 *  set时机:
	 * 		{@link org.springframework.context.support.ApplicationContextAwareProcessor#postProcessBeforeInitialization(Object, String)}
	 *
	 */

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("bean实例化前的后置处理器 对于实现Aware相关接口的类,进行Aware Set ApplicationContextAware");
		this.applicationContext = applicationContext;
	}
}