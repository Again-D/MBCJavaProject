package database.persons;

import java.util.List;

public class PersonsMain {

	public static void main(String[] args) {
		// // test1 - insert 테스트
		// // 1. 추가할 데이터 생성
		// PersonsVO vo = new PersonsVO(0, "javatest", "test", 17, "Seoul");
		// // 2. DAO 객체 호출
		// PersonsDAO dao = new PersonsDAO();
		// // 3. 작업 처리 - insert()함수 호출
		// int result = dao.insert(vo);
		// if (result > 0) {
		// 	System.out.println("레코드 등록 성공");
		// } else {	// result가 0이면 실패...
		// 	System.out.println("레코드 등록 실패");
		// }
		// test2 - select 테스트
		// 1. DAO 객체 호출
//		PersonsDAO dao = new PersonsDAO();
		// 싱글톤인 경우
		PersonsDAO dao = PersonsDAO.getInstance();
		// 2. DAO 객체에 있는 select 처리할 메서드 호출. 1) 전체 출력. 2) firstname으로 출력
		// 1) 전체 출력
		List<PersonsVO> list = dao.selectAll();
		for (PersonsVO vo : list) {
			System.out.println(vo);
		}
		System.out.println("=====================================");
		System.out.println();
		// 2) 부분조회(firstname)
		list = dao.selectOneName("test");
		System.out.println("firstname에 'test'가 있는 경우 레코드 출력");
		for (PersonsVO vo : list) {
			System.out.println(vo);
		}
		System.out.println("=====================================");
		System.out.println();
		// 2) 부분조회(id)
		System.out.println("id가 10인 경우 레코드 출력");
		System.out.println(dao.selectOne(10));
		
		// 실습 PersonsDAO 객체, update(), delete() 메서드 구현
		//	- update()는 매개변수 타입으로 PersonsVO를 받고, 반환값은 0,1로 반환
		//			=> public int update(PersonsVO vo)
		// 		0 인경우 -> 실패, 1인 경우 -> 성공
		//		sql => update persons set lastname = ?, firstname = ?, age = ?, city= ?
		//			where id = ?
		//	- delete()는 매개변수 타입으로 int로 전달값은 id값을 전달.
		// 		0 인경우 -> 실패, 1인 경우 -> 성공
		//		sql => delete from persons where id=?
		
		// test3 update()
//		PersonsVO mod = new PersonsVO(11,"testuser","testuser",38,"Busan");
		PersonsVO mod = dao.selectOne(11);
		mod.setFirstname("modified");
		mod.setAge(100);
		if(dao.update(mod) != 0) {
			System.out.println("Update 성공");
			System.out.println("수정결과 : "+dao.selectOne(mod.getId()));
		} else {
			System.out.println("Update 실패");
		}
		
		// test 4) 삭제
		if (dao.delete(14) == 1) {
			System.out.println("Delete 성공");
		} else {
			System.out.println("Delete 실패");
		}
		/*
		 * [Persons 처리하는 프로그램]
		 * 1. 전체 조회(레코드 전체 정보를 출력)
		 * 2. 선택 조회(멤버의 id 또는 이름을 이용한 정보조회)
		 * 3. 레코드 추가 (Persons DB에 레코드 정보를 입력 받아서 추가)
		 * 4. 레코드 수정 (ID를 입력 받아서 해당 레코드를 수정)
		 * 	(수정시에 ID에 해당하는 정보를 사전에 출력해서 변경)
		 * 	ex) 변경할 ID['test'] 입력하세요 :
		 * 		변경할 이름['홍길동']을 입력하세요 :
		 * 5. 레코드 삭제(ID를 입력받아서 해당 레코드를 삭제)
		 * 위의 내용을 메뉴로 만들어서 구동하게 작성
		 * 각 기능은 메서드로 구성하여 만들어 주세요!
		 */
		
		


	}

}
