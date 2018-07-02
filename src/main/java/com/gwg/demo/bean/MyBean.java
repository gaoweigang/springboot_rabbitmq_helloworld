package com.gwg.demo.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *1.@RestController 是构造型注解，类似于 @Controller会创建一个bean
 *
 *2.@ConfigurationProperties 绑定YAML文件中的属性
 */
@RestController
@ConfigurationProperties(prefix="my")
public class MyBean {

	/**
	 * 将application.properties文件捆绑到jar内，用来提供一个合理的默认name属性值
	 */
	@Value("${person.name}")
	private String name;
	/**
	 * 测试生成整形随机数 
	 */
	@Value("${random.int}")
	private int age;
	
	/**
	 * 使用Spring DataBinder工具绑定YAML文件中的属性(这是@ConfigurationProperties做的事)，你需要确定目标bean中
	 * 必须要有可变的值初始化它(因为List是可变的，所以就不用配置相应的setter方法)，
	 * 比如，下面的代码将绑定上面的属性
	 */
	private List<String> servers = new ArrayList<String>();
	
	/**
	 * 推荐使用，尽量不要使用@Value()这种方式，这种方式太笨重了
	 * 使用Spring DataBinder工具绑定YAML文件中的属性(这是@ConfigurationProperties做的事)，你需要确定目标bean中
	 * 必须要有setter方法(因为String是不可变的，所以必须配置setter方法)，比如，下面的代码将绑定上面的属性
	 */
	private String mother;
	
	/**
	 * 松散绑定(Relaxed binding):application.yml中的字段不必和bean中的成员变量名完全一致 
	 * 必须要有相应setter()方法
	 */
	private String firstName;
	
	@Autowired
	private ConnectionSettings connection;
	
	@Autowired
	private Foo foo;
	
	@RequestMapping("/hello")
	public String hello(){
		
		return "Hello  "+name +
				"<br/>age :"+age +
				"<br/>servers: " + this.getServers() + 
				"<br/>mother: "+ this.getMother()+
				"<br/>first-name:"+firstName;
	}
	
	
	@RequestMapping("/connectionTest")
	public String connection(){
		return connection.toString();
	}


	public List<String> getServers() {
		return servers;
	}


/*	public void setServers(List<String> servers) {
		this.servers = servers;
	}*/

	public String getMother() {
		return mother;
	}


	public void setMother(String mother) {
		this.mother = mother;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
