package exam.members;

import java.util.List;
import java.util.Scanner;


public class MembersProgram {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		MembersDAO dao = MembersDAO.getInstance();
		while (true) {
			menu();
			System.out.print("메뉴선택>> ");
			int menu = scan.nextInt();
			switch (menu) {
			case 1:
				// 멤버추가
				System.out.println("멤버를 추가합니다.");
				try {
					MembersVO vo = newMember();
					if(dao.insert(vo) !=0) {
						System.out.println("추가 완료");
					} else {
						System.out.println("추가에 실패했습니다.");
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 2:
				// 멤버조회
				System.out.println("1) 전체 멤버 출력 2) 사용자계정으로 검색 3) 이름으로 검색 0)나가기");
				System.out.print("메뉴선택>> ");
				int menu2 = scan.nextInt();
				switch (menu2) {
					case 1:
						List<MembersVO> listAll = dao.selectAll();
						for (MembersVO vo : listAll) {
							System.out.println(vo.toString());

						}
						break;
					case 2:
						System.out.println("검색할 사용자 계정을 입력하세요");
						System.out.print("사용자계정(userId) : ");
						String searchId = scan.next();
						System.out.println(dao.selectOneUserId(searchId));
						break;
					case 3:
						System.out.println("검색할 사용자의 이름을 입력하세요");
						System.out.print("사용자의 이름: ");
						String searchName = scan.next();
						List<MembersVO> listName = dao.selectOneName(searchName);
						for (MembersVO vo : listName) {
							System.out.println(vo.toString());
						}
						break;
					case 0:
						break;
				

					default:
						System.out.println("값 입력이 잘못되었습니다.");
				}
				break;
			case 3:
				// 멤버 정보 수정
				System.out.println("정보를 수정할 사용자계정명 을 입력하세요");
				System.out.print("사용자계정 입력: ");
				String searchUser = scan.next();
				if(dao.update(searchUser) != 0) {
					System.out.println("수정 완료");
				} else {
					System.out.println("수정 실패");
				}
				break;
			case 4:
				// 멤버 정보 삭제
				System.out.println("삭제할 멤버의 ID를 입력하세요");
				System.out.print("삭제할 ID : ");
				try {
					int deleteId = scan.nextInt();
					if (dao.delete(deleteId) != 0) {
						System.out.println("삭제 완료");
					} else {
						System.out.println("삭제 실패");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 5:
				// 프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				scan.close();
				System.exit(0); // 프로세스 종료...
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + menu);
			}
		}
	}

	public static void menu() {
		System.out.println(
				"[Member 관리 프로그램]\n"
				+ "1. 멤버 추가\n"
				+ "2. 멤버 조회\n" 
				+ "\t 1) 전체 멤버 출력\n"
				+ "\t 2) 사용자계정을 이용한 검색\n" 
				+ "\t 3) 이름을 이용한 검색\n"
				+ "3. 멤버 정보 수정 (사용자계정)\n" 
				+ "4. 멤버 정보 삭제 (ID)\n"
				+ "5. 프로그램 종료");
	}
	public static MembersVO newMember() {
		MembersVO vo = new MembersVO();
		try {
			System.out.print("새 사용자계정(UserId) : ");
			vo.setUserId(scan.next());
			System.out.print("새 비밀번호: ");
			vo.setUserPw(scan.next());
			System.out.print("이름: ");
			vo.setName(scan.next());
			System.out.print("나이: ");
			vo.setAge(scan.nextInt()); 
			System.out.print("휴대전화번호: ");
			vo.setPhone(scan.next());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
		
	}
}