package ch11;

//Runtime Exception(실행 예외)  -> UncheckException -> 컴파일러 예외 확인하지 않음.
public class ExceptionExample1 {

 public static int makeException(int input) {
    int divide = 0;
    int result = input/divide;   // java.lang.ArithmeticException: / by zero
    return result;
 }
 
 public static void makeException2() {
    String s= "가";
    System.out.println(s.charAt(1)); //  java.lang.StringIndexOutOfBoundsException: 
 }
 
 public static void makeException3() throws Exception  { 	// 예외를 호출한 위치로 넘김.
	 														// java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
    int[] a = { 1, 2, 3};
    System.out.println(a[3]);
 }
 
 public static void makeException4() {	// java.lang.NullPointerException:
	 									//Cannot invoke "String.split(String)" because "nothing" is null
    String nothing = null;
    System.out.println(nothing.split(""));
 }
 
 public static void makeException5() {	 //java.lang.NumberFormatException: For input string: "가나다"
    String notInt = "가나다";
    int a = Integer.parseInt(notInt);
 }
 
 public static void makeExcetpion6() {	//java.lang.StackOverflowError
    for(int i = 0; i < Integer.MAX_VALUE; i++) {
       makeExcetpion6();
    }
 }
 
 public static void makeException7() {	// java.lang.ArrayStoreException: java.lang.Integer
    Object[] objArr = new String[3];
    objArr[0] = 0;
 }
 
 public static void makeException8() {	// java.lang.ClassCastException: class java.lang.String cannot be cast to class java.lang.Integer (java.lang.String and java.lang.Integer are in module java.base of loader 'bootstrap')
    Object[] objArr = new String[3];
    objArr[0] = "0";
    Integer a = (Integer) objArr[0];
 }
 
 public static void main(String[] args) throws Exception {
    
//    makeException(10);
//    makeException2();
	 makeException3();		// 이 메서드는 thorws를 사용하여 예외 사항을 호출한 곳으로 넘김.
	 						// 이 메서드를 호출한 곳에서 예외 처리를 진행해야 함.
	 						// 예외 처리 방법은 1) try - catch - finally 구문의 사용과
	 						// 			   2) throws가 있음.
//	 makeException4();
//	 makeException5();
//	 makeExcetpion6();
//	 makeException7();
//	 makeException8();

 }

}

