package com.hnu.cloudmining;
public class myCounter{
	private String name = "xiaowei";
	private int size = 0;
	
	public void setName(String name){
		this.name = name;
	}
	public void setSize(int size){
		this.size = size;
	}
	
	public String getName(){
		return this.name;
	}
	public int getSize(){
		size +=1;
		return size;
	}
	
}