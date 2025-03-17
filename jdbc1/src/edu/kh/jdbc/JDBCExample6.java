package edu.kh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBCExample6 {

	public static void main(String[] args) {

		// 아이디, 비밀번호, 이름을 입력받아
		// 아이디, 비밀번호가 일치하는 사용자의
		// 이름을 수정 (UPDATE)
		
		// 1. PreparedStatement 이용하기
		// 2. commit/rollback 처리하기
		// 3. 성공 시 "수정 성공!" 출력 / 실패 시 "아이디 또는 비밀번호 불일치" 출력
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		Scanner sc = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String userName = "kh";
			String password = "kh1234";
			
			conn = DriverManager.getConnection(url, userName, password);
			
			System.out.print("아이디 입력 : ");
			String id = sc.nextLine();
			
			System.out.print("비밀번호 입력 : ");
			String pw = sc.nextLine();
			
			System.out.print("이름 입력 : ");
			String name = sc.nextLine();
			
			String sql = """
					INSERT INTO TB_USER
					VALUES(SEQ_USER_NO.NEXTVAL, ?, ?, ?, DEFAULT)
					""";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			
			conn.setAutoCommit(false);
	
			int result = pstmt.executeUpdate();
			
			
			if(result > 0) {
				System.out.println(name + "님이 추가 되었습니다.");
				conn.commit();
				
			} else { // 실패
				System.out.println("추가 실패");
				conn.rollback();
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
