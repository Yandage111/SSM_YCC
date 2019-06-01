package com.YCC.entity;

public class manager  {
	
	private String UserName;
	private String RealName;
	private Integer age;
	private String password;
	private String sex;
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getRealName() {
		return RealName;
	}
	public void setRealName(String realName) {
		RealName = realName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public manager(String userName, String realName, Integer age,
			String password, String sex) {
		super();
		UserName = userName;
		RealName = realName;
		this.age = age;
		this.password = password;
		this.sex = sex;
	}
	public manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "manager [UserName=" + UserName + ", RealName=" + RealName
				+ ", age=" + age + ", password=" + password + ", sex=" + sex
				+ "]";
	}
	
	
}
