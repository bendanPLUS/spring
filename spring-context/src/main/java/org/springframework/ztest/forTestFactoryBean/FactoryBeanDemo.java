package org.springframework.ztest.forTestFactoryBean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;

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
