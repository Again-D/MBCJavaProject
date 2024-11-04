package ch6;

public class FinalExample {

	
	public static void main(String[] args) {
		// final 테스트
		Person hong = new Person("111111-1111111", "홍길동");
		// nation, ssn => final로 설정되어 있음...
		hong.name = "홍두깨";
//		hong.nation = "율도국";	// 에러 : 변경 X
//		hong.ssn = "000001111";	// 에러 : 변경 X
		
		
		System.out.println("[" + hong.name + ", " + hong.nation + ", " + hong.ssn + "]");
	}

}


class Person {
	// final 테스트를 위한 Person 클래스..
	// final을 사용하면 변수를 상수화 처리를 하게 됩니다.
	
		
	// 필드(멤버변수) -- final 초기화 방법
	final String nation = "한국";		// 1. 선언시 초기화
	final String ssn;
	String name;
	
	public Person(String ssn, String name) {
		this.ssn = ssn;				// 2. 생성자를 이용한 초기화
		this.name = name;
	}
	
	
}