package pers.example.model;

public class User {
	
	private String id;//编号
	  
	private String name;//名字
	  
	private String password;//密码
	  
	private Integer age;//年龄
	  
	public String getId() {
		 return id;
	}
	
	public void setId(String id) {
		 this.id = id;
	}
	
	public String getName() {
		 return name;
	}
	
	public void setName(String name) {
		 this.name = name;
	}
	
	public String getPassword() {
		 return password;
	}
	
	public void setPassword(String password) {
		 this.password = password;
	}
	
	public Integer getAge() {
		 return age;
	}
	
	public void setAge(Integer age) {
		 this.age = age;
	}
	
}