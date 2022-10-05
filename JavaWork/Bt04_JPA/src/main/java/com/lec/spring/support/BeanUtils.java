package com.lec.spring.support;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanUtils implements ApplicationContextAware{

	private static ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// 생성된 ApplicationContext 를 받아온다
		BeanUtils.applicationContext = applicationContext;		
	}
	
	// 해당 T 클래스에 맞는 Bean 을 ApplicationContext 에서 받아오는 메소드
	public static <T> T getBean(Class<T> clazz) {
		return applicationContext.getBean(clazz);
	}
	
}

