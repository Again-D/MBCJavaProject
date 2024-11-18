package study;

import java.util.Scanner;

public class First3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person1 p1 = new Person1("홍길동",1970);
		Person1 p2 = new Person1("김길동",1985);
		
		p1.cal3(2040, "k");
		p2.cal3(2030, "y");
		

	}

}

// 이름과 출생년도를 저장할 수 있는 Person이라는 클래스 생성
// 매개변수로 기준년도와 K(한국식나이) 또는 Y(연나이)를 입력받아서 해당년도에
class Person1 {
	private String type;
	private int age;
//	private int base_year;
	private int birth_year;
	private String name;
	
	public Person1() {}
	public Person1(String name,int birth_year) {
		this.name = name;
		this.birth_year = birth_year;
		
	}
	
	
	public void cal3(int base_year,String type) {
		switch (type) {
		case "k" :
			if(base_year < birth_year) {
				System.out.println("출생연도 이전의 나이는 계산할 수 없습니다.");
								
			}else {
				age = (base_year - birth_year) +1;
				System.out.println(name+ "님은 "+ base_year + "년에 한국나이 " +age+ "세 입니다.");
			}
			break;
		case "y":
			if(base_year < birth_year) {
				System.out.println("출생연도 이전의 나이는 계산할 수 없습니다.");
								
			}else {
				age =(base_year - birth_year);
				System.out.println(name+ "님은 "+base_year + "년에 연나이 " +age+ "세 입니다.");
			}
			break;
		}
	}
	
	
	
	
}
