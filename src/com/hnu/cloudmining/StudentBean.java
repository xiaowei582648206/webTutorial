package com.hnu.cloudmining;
public class StudentBean{
	private String name;
	private int age;
	private String sex;
	private String school;
	
	public void setName(String name){
		this.name = name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public void setSex(String sex){
		this.sex = sex;
	}
	public void setSchool(String school){
		this.school = school;
	}
	
	public String getName(){
		return this.name;
	}
	public int getAge(){
		return this.age;
	}
	public String getSex(){
		return this.sex;
	}
	public String getSchool(){
		return this.school;
	}
}
