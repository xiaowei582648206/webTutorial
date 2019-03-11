package com.hnu.cloudmining;
import java.util.HashMap;
import java.util.Map;
public class  Register{
	private String name;
	private String age;
	private String email;
	private Map<String,String>  errors = null;
	
	public Register(){
		name="";
		age="";
		email="";
		errors = new HashMap<String,String>();
	}
	
	public  boolean isValidate(){
		boolean flag = true;
		if(!this.name.matches("\\w{6,15}")){
			flag = false;
			this.name = "";
			String key = "errname";
			String value = "用户名输入错误，必须为6到15位数字或字母";
			errors.put(key,value);
		}
		if(!this.age.matches("\\d+")){
			flag = false;
			this.age = "";
			String key = "errage";
			String value = "年龄输入错误，必须为数字";
			errors.put(key,value);
		}
		if(!this.email.matches("\\w+@\\w+\\.\\w+\\.?\\w*")){
			flag = false;
			this.email = "";
			String key = "erremail";
			String value = "邮箱输入错误，必须为符合正确的邮箱格式";
			errors.put(key,value);
		}
		return flag;
	}
	
	public String getErrorMsg(String key){
		String value = this.errors.get(key);
		return value == null ? "" : value;
	}
	
	public String getName(){
		return this.name;
	}
	public String getAge(){
		return this.age;
	}
	public String getEmail(){
		return this.email;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public void setAge(String age){
		this.age = age;
	}
	public void setEmail(String email){
		this.email = email;
	}
}