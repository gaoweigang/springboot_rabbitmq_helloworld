package com.gwg.demo.bean;

public class Foo {
	
	public void gaoweigang(){
		System.out.println("****************Foo init**************"+System.nanoTime());
	}
	
	static{
		System.out.println("****************Foo static block***************"+System.nanoTime());
	}
	
	{
		System.out.println("****************Foo block*****************"+System.nanoTime());
	}
	
    public Foo(){
    	System.out.println("================Foo Construct======================"+System.nanoTime());
    }

}
