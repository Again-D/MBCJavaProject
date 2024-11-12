package quiz;

import java.util.Calendar;
import java.util.Scanner;


public class CalendarQuiz {

	// 년, 월,일을 입력받고 해당 날짜가 무슨 요일인지 출력하는 프로그램 장석하시오.
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner scan = new Scanner(System.in); 
		
		System.out.print("년도: ");
		int year = scan.nextInt();
		System.out.print("월: ");
		int month = scan.nextInt();
		System.out.print("일: ");
		int date = scan.nextInt();
		getDayOfWeek(year, month, date);
		
	}
		
		
	static void getDayOfWeek(int year, int month, int date) {
			
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, year);
			cal.set(Calendar.MONTH, month-1);
			cal.set(Calendar.DATE, date);
			
		switch (cal.get(Calendar.DAY_OF_WEEK)) {
		case 1: {
			System.out.printf("%d년 %d월 %d일은 월요일 입니다.",year,month,date);
		}
		case 2: {
			System.out.printf("%d년 %d월 %d일은 월요일 입니다.",year,month,date);
			break;
		}
		case 3: {
			System.out.printf("%d년 %d월 %d일은 화요일 입니다.",year,month,date);
			break;
		}
		case 4: {
			System.out.printf("%d년 %d월 %d일은 수요일 입니다.",year,month,date);
			break;
		}
		case 5: {
			System.out.printf("%d년 %d월 %d일은 목요일 입니다.",year,month,date);
			break;
		}
		case 6: {
			System.out.printf("%d년 %d월 %d일은 금요일 입니다.",year,month,date);
			break;
		}
		default:{
			System.out.printf("%d년 %d월 %d일은 토요일 입니다.",year,month,date);
	
		}
		}
	}
			
		
}
