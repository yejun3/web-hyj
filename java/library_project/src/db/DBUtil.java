package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	// DB 정보는 고정값 → static + final 사용
	//주소
	private static final String URL = "jdbc:mysql://localhost:3306/rental_db";
	//아이디
	private static final String USER = "root";
	//비밀번호
	private static final String PASSWORD = "11111111";
        
	 
	// DB 연결 메서드
	public static Connection getConnection() {
		//연결에 성공하면 connection 객체를 반환
		
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}

		return conn;
	}
}