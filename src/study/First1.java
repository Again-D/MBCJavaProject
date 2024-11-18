package study;

import java.util.Scanner;

public class First1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 1. K(한국식 나이), Y(연나이)
		// 2. 출생년도(4자리)
		String ageType;
		int birthYear;
		
		System.out.println("출생년도를 입력하세요.");
		System.out.print("출생년도 입력: ");
		birthYear = scan.nextInt();
		System.out.println("2030년에 한국식 나이계산 (k) 연나이계산 (y) 기준연도입력 계산 (b)");
		System.out.print("방식입력: ");
		ageType = scan.next();
		
		switch (ageType) {
		case "k":			
			System.out.println("2030년에 한국식나이로"+ (2030-birthYear+1) + " 세 입니다.");
			break;
		case "y":
			System.out.println("2030년에 연나이로"+ (2030-birthYear)+ " 세 입니다.");
			break;
		}
		
		
		

	}

}
