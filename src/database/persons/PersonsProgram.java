package database.persons;

import java.util.Scanner;

public class PersonsProgram {
	
	
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		PersonsDAO dao = PersonsDAO.getInstance();	
		
		while(true) {
			menu();
			System.out.print("메뉴선택>> ");
			String menu = scan.next();
			menu = menu.toLowerCase();
			switch (menu.charAt(0)) {
			case '1' :
				// 전체 조회
				dao.selectAll();
				
				break;
			case '2' :
				// 선택 조회
				break;
			case '3' :
				// 레코드 추가
				break;
			case '4' :
				// 레코드 수정
				break;
			case '5':
				break;
			case 'q':
			case 'Q':
			case 'ㅂ':
				System.out.println("프로그램을 종료합니다.");
	            scan.close();
	            System.exit(0);   // 프로세스 종료... 
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + menu.charAt(0));
			}
		}
		

	}
	
	public static void menu() {
		System.out.println(
				"[Persons 처리하는 프로그램]\n"
				+"1. 전체 조회(레코드 전체 정보를 출력)\n"
				+"2. 선택 조회(멤버의 id 또는 이름을 이용한 정보조회)\n"
				+"3. 레코드 추가 (Persons DB에 레코드 정보를 입력 받아서 추가)\n"
				+"4. 레코드 수정 (ID를 입력 받아서 해당 레코드를 수정)\n"
				+"5. 레코드 삭제(ID를 입력받아서 해당 레코드를 삭제)\n"
				+"종료하려면 q(Q)또는 ㅂ을 입력하세요."
				);
	}

}
