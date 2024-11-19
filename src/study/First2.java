package study;

import java.io.IOException;
import java.util.Scanner;

public class First2 {

	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		
			ageCal(1999,2030,"k");
			System.out.println("해당 년도에 "+ageCal(1999,2030,"k")+ "세 입니다");
		
	}
	
	static int ageCal(int birthYear,int baseYear,String ageType) throws Exception {
		// 1. K(한국식 나이), Y(연나이)
		// 2. 출생년도(4자리)
		
		switch (ageType) {
			case "k":
			case "K":
				return (baseYear-birthYear+1) ;
			case "y":
			case "Y":	
				return (baseYear-birthYear);
			default:
				throw new Exception("잘못된 ageType 입니다.");
				
		}

		
	}

}


