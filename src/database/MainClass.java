package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainClass {
    
    public static void main(String[] args) {
    	// JDBC 연결...
    	// Connection 객체 생성
    	Connection conn = null;
    	try {
    		// 1. Driver Loading 
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. Connection 객체 생성. DriverManager를 통해서
			conn = DriverManager.getConnection(
					"jdbc:mysql://192.168.0.138:3306/testdb?serverTimezone=Asia/Seoul",
					"testuser1",
					"P@ssw0rd"
					);
			System.out.println(conn);
			System.out.println("데이터 베이스 접속");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
		} catch (SQLException sqle) {
			System.out.println("DB 연동 실패");
			sqle.printStackTrace();
			
		} finally {
			try {
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	
			       
    }
}

