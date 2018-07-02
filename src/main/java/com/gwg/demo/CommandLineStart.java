package com.gwg.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 如果你想获取原始的命令行参数，或一旦SpringApplication启动，你需要运行一些特定的代码，你可以实现CommandLineRunner
 * 接口。在所有实现该接口的Spring beans上将调用run(String args)方法
 * 
 *
 */
@Component
public class CommandLineStart implements CommandLineRunner{
	public void run(String... arg0) throws Exception {
		
		System.out.println("***********************************");
	}

}
