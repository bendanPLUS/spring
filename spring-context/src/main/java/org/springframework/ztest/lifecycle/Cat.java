package org.springframework.ztest.lifecycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("factoryBeanDemo")
public class Cat {

	@Autowired
	Person person;



}
