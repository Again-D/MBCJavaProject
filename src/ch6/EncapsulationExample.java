package ch6;

public class EncapsulationExample {
	/*
	 *  은닉(Encapsulation) - 캡슐화
	 *  - 은닉은 사용자에게 상세한 내부 구현을 숨기고, 필요한 부분만 보이게 만드는 것을 말함.
	 *  - 은닉을 사용하기 위해서는 클래스의 멤버변수(필드)의 접근 제한자를 private으로 설정한다.
	 *  - 은닉된 멤버변수(필드)에 접근하기 위해서는 공개된(public) 메서드를 통해서 접근할 수 있다.
	 *   이렇게 변수의 값을 변경하는데 사용되는 메서드를 Setter 메서드라고 하고, 변수의 값을 불러오는
	 *   메서드를 Getter라 메서드라고 한다.
	 *   - 이렇게 공개 메서드를 이용하여 데이터를 변경시킬 경우 메서드 내에 데이터 유효성을 검증한 루틴을
	 *   작성할 수 있다. 
	 *   - 뿐만 아니라 경우에 따라 접근 권한을 체크할 수 있는 로직을 포함하면 인가되지 않은 사용자에게 중요한
	 *    데이터나 로직을 숨길 수 있다.
	 *    - 꼭 멤버변수(필드)만 private으로 제한하는 것은 아니고, 외부에 공개하고 싶지 않은 매서드듫도 private
	 *    처리할 수 잇다.
	 *  
	 *  
	 *  
	 * 	
	 */
	
	
	public static void main(String[] args) {
		// MyDate 테스트	
		Mydate myBirth = new Mydate();
		myBirth.setDay(32);	// 날짜가 잘못된 경우 day = 1 로 설정 저장
		System.out.println("My birth day is " + myBirth.getDay());

}

}
class Mydate {
	// 은닉을 사용하지 않는 경우 ... 누구든지 접근하레 하려면, public으 로 설정
//	public int day;
//	public int month;
//	public int year;
	
	private int day;
	private int month;
	private int year;
	
	// Getter, Setter
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		if( (day < 1) || (day > 31)) {	// day 가 1보다 작거나, 31보다 큰 경우
			System.out.println("잘못된 날짜 입력입니다.");
			this.day = 1;	// 날짜 초기 시작값
		}else {
			this.day = day;
		}
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
}