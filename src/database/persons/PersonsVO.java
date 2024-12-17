package database.persons;

public class PersonsVO {
	// JAVA 프로그래밍에서 VO 또는 DTO 객체는 데이터를 저장하는 객체
	// VO는 DB와 연동할 데이터를 저장하는 객체,
	// DTO는 데이터를 전달하는 객체로 사용.
	// DB연동 동작에 대해서 DAO를 생성하여 작업을 진행.
	
	//-----------------------------------------------------------
	// Persons 테이블에 있는 컬럼: ID, LastName, FirstName, Age, City
	private int id;
	private String firstname;
	private String lastname;
	private int age;
	private String city;
	
	// 생성자
	// 기본 생성자
	public PersonsVO() {}
	
	// 필드 생성자
	public PersonsVO(int id, String firstname, String lastname, int age, String city) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.city = city;
	}

	// 메서드
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

	@Override
	public String toString() {
		return "PersonsVO [id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", age=" + age
				+ ", city=" + city + "]";
	}

	
    
	
	


    



}
