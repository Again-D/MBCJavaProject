package program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import program.obj.Customer;

public class CustomerManager3 {
	
	// CustomerManager2(배열)를 참조하여 데이터의 타입을 Collection으로 변경해서 수정 작업을 진행!!
	
	// Customer라는 클래스를 불러와서 고객 정보를 저장하는 객체로 삼고 동작하는 고객관리 프로그램. 

	// 멤버 변수 선언
	
	
	// 고객 정보를 저장할 변수를 Collection Type으로 선언(이름, 성별, 이메일, 출생년도)
	// Collection 타입 객체 선언
	static List<Customer> cusList = new ArrayList<>();
	
	// 기존에 사용했던 index는 사용 안해도 됨... 객체 내에 고유 정보를 통한 검색을 이용할 예정.
	
	// cusList.size()는 사용... 저장한 데이터의 크기.
	
	
	// 기본 입력 장치로부터 데이터를 입력 받기 위해서 Scanner 객체를 생성
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		// 메뉴 작성... 
		while (true) {
			System.out.printf("\n[Info] 고객 수 : %d \n", cusList.size());
			System.out.println("메뉴를 선택해 주세요 : ");
			System.out.println("(I)nsert, (S)elect, (U)pdate, (D)elete, (Q)uit");
			System.out.print("메뉴 입력 : ");
			String menu = scan.next();
			menu = menu.toLowerCase();
			
			switch(menu.charAt(0)) {
				case 'i':
				case 'ㅑ':
					System.out.println("고객 정보 입력을 시작합니다.");	
					insertCustomerData();
					System.out.println("고객 정보를 저장했습니다.");
					break;
				case 's':
				case 'ㄴ':
					System.out.println("고객 정보를 출력합니다.");
					if(cusList.size() > 0) printCustomerData(selectCustomerData());
					else System.out.println("출력할 데이터가 없습니다.");
					break;
				case 'u':
				case 'ㅕ':
					System.out.println("데이터를 수정합니다.");
					if(cusList.size() > 0) {
					updateCustomerData(selectCustomerData());
					} else {
						System.out.println("수정할 데이터가 선택되지 않았습니다.");
					}
					break;
				case 'd':
				case 'ㅇ':
					System.out.println("데이터를 삭제합니다.");
					if (cusList.size() > 0) {	//	삭제하기 위해서 실제데이터가 존재해야 삭제할 수 있음...
						deleteCustomerData(selectCustomerData());
					}else {
						System.out.println("삭제할 데이터가 선택되지 않았습니다.");
					}
					break;
				case 'q':
				case 'ㅂ':
					System.out.println("프로그램을 종료합니다.");
					scan.close();
					System.exit(0);   // 프로세스 종료... 
				default:
				System.out.println("메뉴를 잘 못 선택했습니다.");
			}	
		}			
			
	} // main()
	
	// 고객 정보 추가 메서드
	public static void insertCustomerData() {
		System.out.print("이름 : ");
		String name = scan.next();
		System.out.print("성별(M/F) : ");
		String gender = scan.next();
		System.out.print("이메일 : ");
		String email = scan.next();
		System.out.print("출생년도 : ");
		int birthYear = scan.nextInt();
		
		Customer c1 = new Customer(name, gender, email, birthYear);
		/*
		 *	Customer c1 = new Customer();
		 *	c1.setName(name);
		 *	c1.setGender(gender);
		 *	c1.setEmail(email);
		 *	c1.setBirthYear(birthYear);
		 *
		 */
		cusList.add(c1); 
	}
	
	// 고객 정보 출력 메서드
	public static void printCustomerData(Customer cus) {
		if (cus.getName() == null) {
			System.out.println("메뉴로 돌아갑니다.");
		}else {
			System.out.println("=================== Customer Info =====================");
			System.out.println(cus.toString());
			System.out.println("=======================================================");
		}
	}
	// 고객 정보 검색 메서드... selectCustomerData()
	// 고객 정보 검색은 고유값을 이용함... 이름... 
	public static Customer selectCustomerData() {
		// 고객 이름을 통해서 검색 작업... 
		while(true) {
			System.out.println("출력, 수정 또는 삭제할 사람의 이름을 입력해 주세요  ");
			System.out.println("돌아가기 : q");
			String name = scan.next();
			for (int i = 0; i < cusList.size(); i++) {
				if (cusList.get(i).getName().equals(name)) {	//현재 보고있는 객체의 이름과 입력이름 비교
					return cusList.get(i);		// 1) 함수(메서드)의 종료, 2) 반환값 처리
				}
			}
			System.out.println("입력하신 이름을 가진 데이터가 없습니다.");
			// while로 인한 무한반복에서 나가기 동작
			if (name.equals("q") || name.equals("Q") || name.equals("ㅂ")){
				return new Customer();
								
			}
			
			// 이름을 잘못 입려가헉나 입력하지 않은 상황에는 while문을 계속 반복하는 상황.
			// 해당 메서드에서 나갈수 있는 상황 제공 (q 입력시 나가기)
			
		}
	}	//	selectCustomerData End
	
	//	고객 정보 수정 메서드.. updateCustomerData()
	public static void updateCustomerData(Customer cus) {
		if (cus.getName() == null) {
			System.out.println("메뉴로 돌아갑니다.");
		}else {				
			System.out.println("===== Update Customer Info =====");
			System.out.print("이름("+cus.getName()+") :");		
			cus.setName(scan.next());
			System.out.print("성별("+cus.getGender()+") :");
			cus.setGender(scan.next());
			System.out.print("이메일("+cus.getEmail()+") :");
			cus.setEmail(scan.next());
			System.out.print("출생년도("+cus.getBirthYear()+") :");
			cus.setBirthYear(scan.nextInt());
		}
		
	}	//	updateCustomerData End
	
	public static void deleteCustomerData(Customer cus) {
		if (cus.getName() == null) {
			System.out.println("메뉴로 돌아갑니다.");
		}
		for (int i = 0; i < cusList.size() ; i++) {
			//	cus에 있는 name과 Customer 배열에 있는 객체들의 name들을 비교
			if(cusList.get(i).getName().equals(cus.getName())) {	//	cus와 객체배열에 있는 이름이 같은 것 찾기
				//	삭제 처리
				cusList.remove(cusList.get(i));
				}
			}
			System.out.println("데이터가 삭제 되엇습니다.");
				
		}
		
	}

		
	
