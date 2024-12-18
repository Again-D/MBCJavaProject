package exam.members;

public class MembersVO {
	// 컬럼 - id, userId, userPw,age, phone, createDate
	private int id;
	private String userId;
	private String userPw;
	private String name;
	private int age;
	private String phone;
	private String createDate;
	
	// 생성자
	public MembersVO() {}
		
	public MembersVO(int id, String userId, String userPw, String name, int age, String phone, String createDate) {
		this.id = id;
		this.userId = userId;
		this.userPw = userPw;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.createDate = createDate;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", userId=" + userId + ", userPw=" + userPw + ", name=" + name + ", age=" + age
				+ ", phone=" + phone + ", createDate=" + createDate + "]";
	}
	
	
	
	
	
	
	
	

}
