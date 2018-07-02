package com.gwg.demo.bean;

import java.net.InetAddress;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="connection")
public class ConnectionSettings {
	
	private String username;
	
	/**
	 * Spring Boot将尝试校验外部的配置
	 * NotNull校验remoteAddress字段不能为空，否则启动服务将会报错
	 */
	//@NotNull
	private InetAddress remoteAddress;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public InetAddress getRemoteAddress() {
		return remoteAddress;
	}

	public void setRemoteAddress(InetAddress remoteAddress) {
		this.remoteAddress = remoteAddress;
	}
	
	@Override
	public String toString() {
		return "username :" + username + ", remote :"+remoteAddress;
	}

}
