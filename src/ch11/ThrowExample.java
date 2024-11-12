package ch11;

// 예외 처리 방법 : throw
public class ThrowExample {

	public static String[] greetings = { "안녕","Hi","안나옴"};		
	
	public static void doIt(int index) throws ArrayIndexOutOfBoundsException {
		// throws 사용한 경우 예외 처리를 메서드를 호출한 곳에 넘김
		System.out.println(greetings[index]);
	}
public static void doIt2(int index) {
	try {
		// 예외 발생할 여지가 있는 코드 집중 구간
		System.out.println(greetings[index]);
	} catch (ArrayIndexOutOfBoundsException e) { // 예외 처리 구간
		e.printStackTrace();
	}
	
}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = (int) (Math.random()*4); 	// 0,1,2,3
		//main에서 예외처리..
//		try {
//			doIt(i);
//		}catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("main에서 i가 잘못된 값을 넘겼습니다. 다음으로 진행합니다.");
//		}
		// doit2() 내에서 예외 처리
		doIt2(i);
		System.out.println("다음 명령문들이 실행됩니다.");

		
	}

}