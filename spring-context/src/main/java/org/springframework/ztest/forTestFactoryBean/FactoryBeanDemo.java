package org.springframework.ztest.forTestFactoryBean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;
/**
 * FactoryBean 学习参考:
 * https://zhuanlan.zhihu.com/p/229003633
 * https://blog.csdn.net/weixin_37862824/article/details/125531738
 */
@Service
public class FactoryBeanDemo implements FactoryBean<SubBean> {
	@Override
	public SubBean getObject() throws Exception {
		return new SubBean();
	}
	@Override
	public Class<?> getObjectType() {
		return SubBean.class;
	}
}
