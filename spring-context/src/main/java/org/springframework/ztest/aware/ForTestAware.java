package org.springframework.ztest.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ForTestAware implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	/**
	 *  bean实例化前的后置处理器 对于实现Aware相关接口的类,进行Aware处理 重写Set方法
	 *  set时机:
	 * 	{@link org.springframework.context.support.ApplicationContextAwareProcessor#postProcessBeforeInitialization(Object, String)}
	 */

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("bean实例化前的后置处理器 对于实现Aware相关接口的类,进行Aware Set ApplicationContextAware");
		this.applicationContext = applicationContext;
	}
}