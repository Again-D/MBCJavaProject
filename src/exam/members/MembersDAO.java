package exam.members;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MembersDAO {
	Scanner scan = new Scanner(System.in);
	private String url = "jdbc:mysql://192.168.0.138:3306/exam?serverTimezone=Asia/Seoul";
	private String user = "exam";
	private String password = "exam1234";
	
	Connection conn = null;
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private static MembersDAO instance = new MembersDAO();
	
	private MembersDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException ce) {
			System.out.println("드라이버 로드 실패");
			System.out.println(ce.getMessage());
		} catch (SQLException sqle) {
			System.out.println("DB 연동 실패");
			System.out.println(sqle.getMessage());
		}
		
	}

	public static MembersDAO getInstance() {
		return instance;
	}
	
	// 레코드 추가
	public int insert(MembersVO vo) {
		int result = 0;
		try {
			String sql = "insert into Members(userId, userPw, name, age, phone)"
					+ "values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getUserPw());
			pstmt.setString(3, vo.getName());
			pstmt.setInt(4, vo.getAge());
			pstmt.setString(5, vo.getPhone());
			
			result = pstmt.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return result;
	}
	
	// 전체 조회
	public List<MembersVO> selectAll(){
		List<MembersVO> list = new ArrayList<>();
		
		try {
			String sql = "select * from Members";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MembersVO vo = new MembersVO(
						rs.getInt("id"),
						rs.getString("userID"),
						rs.getString("userPw"),
						rs.getString("name"),
						rs.getInt("age"),
						rs.getString("phone"),
						rs.getString("createDate"));
				list.add(vo);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	// userId로 검색
	public MembersVO selectOneUserId(String userId){
		MembersVO vo = null;
		try {
			String sql = "select * from Members where userId like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+userId+"%");			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				 vo = new MembersVO(
						rs.getInt("id"),
						rs.getString("userID"),
						rs.getString("userPw"),
						rs.getString("name"),
						rs.getInt("age"),
						rs.getString("phone"),
						rs.getString("createDate"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	// 이름(name)으로 검색
	public List<MembersVO> selectOneName(String name){
		List<MembersVO> list = new ArrayList<>();
		try {
			String sql = "select * from Members where name like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+name+"%");			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MembersVO vo = new MembersVO(
						rs.getInt("id"),
						rs.getString("userID"),
						rs.getString("userPw"),
						rs.getString("name"),
						rs.getInt("age"),
						rs.getString("phone"),
						rs.getString("createDate"));
				list.add(vo);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	// userid를 이용한 정보수정
	public int update(String searchUserId) {
		int result = 0;
		try {
			String sql ="update Members set userPw=?, name=?,age=?,phone=?"
					+ " where userId like ?";
			pstmt = conn.prepareStatement(sql);
			System.out.print(" 비밀번호 입력: ");
			pstmt.setString(1, scan.next());
			System.out.print(" 이름 입력: ");
			pstmt.setString(2, scan.next());
			System.out.print(" 나이 입력: ");
			pstmt.setInt(3, scan.nextInt());
			System.out.print(" 휴대폰번호 입력: ");
			pstmt.setString(4, scan.next());
			pstmt.setString(5, "%"+searchUserId+"%");
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int delete(int id) {
		int result = 0;
		try {
			String sql = "delete from Members where id =" +id;
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


}
