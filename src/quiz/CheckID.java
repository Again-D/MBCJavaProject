package quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckID {
   
   /*
    *  사용자가 ID를 입력하면, 올바른 ID인지 체크하고, 올바른 ID라면 회원 배열에 추가하는
    *  프로그램을 만들어 봅니다.
    *  확인 내용 : 1)아이디 사이에 공백이 있는지, 2)중복된 아이디 인지 확인,
    *        3) 영어, 숫자,_만 사용가능(다른 문자 사용 불가능), 
    *        4) 글자수 제한 (20자) 
    *        
    *  [메뉴]
    *   ============== 회원 등록 프로그램 ===================
    *   1. 아이디 등록
    *   입력 >> 1
    *   id 입력 >> testuser
    *   입력받은 아이디는 testuser 입니다.
    *   
    *   예외가 발생한 경우... 
    *   공백이 존재합니다. 혹은 중복된 아이디 입니다. 혹은 유효하지 않는 문자가 있습니다.
    *   글자수 제한은 20글자 입니다. ... 
    */

   // List<Member> memList를 생성해서 작업을 진행합니다.
   static List<Member> memlist = new ArrayList<>();
   
   public static void main(String[] args) {
      
	   Scanner scan = new Scanner(System.in);
	   String id ;
	   // 메뉴작성
	   while(true) {
		   System.out.println("============== 회원 등록 프로그램 ===================");
		   System.out.println("1. 아이디 등록");
		   System.out.print("입력>> ");
		   int sel = scan.nextInt();
		   if (sel == 1) {
			   id = scan.next();
//			   memlist.add(id);
		   }
	   }

   }

}

class Member {
   
   String id;
   
   public Member(String id) {
      this.id = id;
   }
   
   @Override
   public String toString() {
      return id;
   }
   
   static void checkSpace(String id) {
	   if (id.contains(" ")) {
		   System.out.println("아이디에 공백을 사용할 수 없습니다.");
	   }
	   else {
		   return;
	   }	     
	   
   }
   static void checkDuplicate(String id) {

}

