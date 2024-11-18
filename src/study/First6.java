package study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.xml.xpath.XPathEvaluationResult;

import study.obj.Person;
;

public class First6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Person age_cal = new Person();
		Map<String, Integer> nameList = new HashMap<>();
		
		int count = 0;
		while (true) {
			System.out.println("==========나이계산기=========");
			System.out.println("1. 목록 2.입력 3.수정 4.삭제 5. 나이계산 6.종료");
			System.out.print("메뉴입력>>");
			int num = scan.nextInt();

			switch (num) {
			case 1: 
				if (nameList.isEmpty()) {
					System.out.println("등록된 정보가 없습니다.");
				}else {
					System.out.println("현재 인원수 : " + nameList.size());
					for (int i = 0; i < nameList.size(); i++) {
						System.out.println(nameList);
					}
				}
				
				
				break;
			case 2:
				System.out.println("정보를 등록합니다.");
				
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				
				break;
			case 6:
				System.out.println("종료합니다.");
				scan.close();
				System.exit(0);
				
			
			default:
				System.out.println("잘못된 입력값입니다.");
			}
			
		}
		
		
		

	}

}

