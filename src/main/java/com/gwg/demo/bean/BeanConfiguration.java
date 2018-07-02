package com.gwg.demo.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * 所有Bean的创建放到Configuration里面
 * 理论上来说，一个项目里面只有一个@Configuration
 */
@Configuration
public class BeanConfiguration {
	
	/**
	 * initMethod初始化Bean,在Bean构建好之后，使用initMethod指定的方法来初始化
	 * @param name
	 * @return
	 */
	@Bean(initMethod = "gaoweigang")
    public Foo foo(@Value("${person.name}")String name){
		System.out.println("============== : "+name);
		return new Foo();
    	
    }

}
