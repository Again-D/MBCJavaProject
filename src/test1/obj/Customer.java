package test1.obj;

import java.io.Serializable;

public class Customer implements Serializable {
	
	private static final long serialVersionUID = 2596454363612688520L;
	private String name;
	private String gender;
	private String email;
	private int birthYear;
	private int age;
	
	
	public Customer() {}

	public Customer(String name, String gender, String email, int birthYear,int age) {
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.birthYear = birthYear;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "이름 = " + name +
				"\n성별 = " + gender +
				"\nemail = " + email + 
				"\n출생년도 = " + birthYear +"년"+ 
				"\n나이 = " + age + "세";
	}
	
	
}
