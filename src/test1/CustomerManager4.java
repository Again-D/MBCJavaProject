package test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import test1.obj.Customer;

public class CustomerManager4 {

	static List<Customer> cuslist = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);
	static Calendar cal = Calendar.getInstance();
	
	
	public static void main(String[] args) {
		

		while (true) {
			System.out.println("=============== 고객정보 관리 프로그램 ==================");
			System.out.println(" 1. 고객 등록 2. 고객 조회 3. 고객 수정 4. 고객 삭제 0. 종료");
			System.out.print("메뉴입력>>");
			int menu = scan.nextInt();
			switch (menu) {
			case 1:
				System.out.println("고객정보를 등록합니다");
				insertCustomerData();
				System.out.println("등록이 완료되었습니다.");
				break;
			case 2:
				System.out.println("고객정보를 조회합니다.");
				if (cuslist.size() > 0) {printCustomerData(selectCustomerData());}
				else {
					System.out.println("표시할 고객정보가 없습니다.");
				}
				break;
			case 3:
				System.out.println("고객정보를 수정합니다.");
				if(cuslist.size() > 0 ) {updateCustomerData(selectCustomerData());}
				else {
					System.out.println("수정할 고객이 없습니다.");
				}
				break;
			case 4:
				System.out.println("고객정보를 삭제합니다.");
				if(cuslist.size()>0) {deleteCustomerData(selectCustomerData());}
				else {
					System.out.println("삭제할 고객이 없습니다.");
				}
				break;

			case 0:
				System.out.println("프로그램을 종료합니다.");
				scan.close();
				System.exit(0);
			default:
				System.out.println("메뉴를 잘못 선택 했습니다.");
			}
		}

	} // main() end

	public static void insertCustomerData() {
		System.out.print("이름 : ");
		String name = scan.next();
		System.out.print("성별(M/F): ");
		String gender = scan.next();
		System.out.print("Email: ");
		String email = scan.next();
		System.out.print("출생년도: ");
		int birthYear = scan.nextInt();
		int age = (cal.get(Calendar.YEAR)-birthYear+ 1) ;
		

		Customer c1 = new Customer(name,gender,email,birthYear,age);
		cuslist.add(c1);
		
		
		

	}

	public static void printCustomerData(Customer cus) {
		if(cus.getName()==null) {
			System.out.println("초기메뉴로 되돌아갑니다.");
		}else {
			System.out.println("=======================");
			System.out.println(cus.toString());
			System.out.println("=======================");
			
		}

	}

	public static Customer selectCustomerData() {
		while(true) {
			System.out.println("출력, 수정 또는 삭제할 고객명을 입력하세요.");
			System.out.println("돌아가기 : q");
			String name = scan.next();
			for (int i = 0; i < cuslist.size(); i++) {
				if (cuslist.get(i).getName().equals(name)) {
					return cuslist.get(i);
				}
			}
			System.out.println("입력하신 이름을 가진 데이터가 없습니다.");
			if (name.equals("q") || name.equals("Q") || name.equals("ㅂ")){
				return new Customer();
								
			}
		}
			
		

	}
		public static void updateCustomerData(Customer cus) {
			if (cus.getName() == null) {
				System.out.println("메뉴로 돌아갑니다.");
			}else {				
				System.out.println("===== 고객정보수정 =====");
				System.out.print("이름("+cus.getName()+") :");		
				cus.setName(scan.next());
				System.out.print("성별("+cus.getGender()+") :");
				cus.setGender(scan.next());
				System.out.print("이메일("+cus.getEmail()+") :");
				cus.setEmail(scan.next());
				System.out.print("출생년도("+cus.getBirthYear()+") :");
				cus.setBirthYear(scan.nextInt());
			}
	}
	
	public static void deleteCustomerData(Customer cus) {
		if (cus.getName() == null) {
			System.out.println("메뉴로 돌아갑니다.");
		}
		for (int i = 0; i < cuslist.size() ; i++) {
			
			if(cuslist.get(i).getName().equals(cus.getName())) {
				//	삭제 처리
				cuslist.remove(cuslist.get(i));
				}
			}
			System.out.println("데이터가 삭제 되엇습니다.");
				
		}
		
	public static void writeCustomerData() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		File file = new File("D:/Temp/test1/CustomerManager.sav");
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void readCustomerData() {
		
	}
	}

