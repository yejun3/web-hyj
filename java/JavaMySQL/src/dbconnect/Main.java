package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {
	public static void main(String[] args) {
		// db접속 경로
		// 형식 
		// jdbc:mysql://서버주소:포트번호/ 데이터베이스명
		String url = "jdbc:mysql://localhost:3306/java_db";
		String user = "root";
		String password = "11111111";
	    //select, insert, update, delete
	    //실행할  sql을 작성
	    //?는 값이 들어갈 자리 (placehoder)
	    String sql = "insert into member(name,email,age) values (?,?,?)";
	    
	      try( //MySQL 서버와 실제 연결을 생성한다.
	  			Connection conn = DriverManager.getConnection(
						url,
						user,
						password);

				// SQL 실행 객체 생성
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) { 	
	           //연결 성공시
	           System.out.println("MySQL 연결 성공");
	           
	         //?부분에 데이터 채우기 
	           pstmt.setString(1,"이영희");
	           pstmt.setString(2,"younghee@test.com");
	           pstmt.setInt(3,25);
	           pstmt.executeUpdate();
	           
	           pstmt.setString(1,"홍길동");
	           pstmt.setString(2,"honggildong@test.com");
	           pstmt.setInt(3,30);
	           pstmt.executeUpdate();
	           
	           pstmt.setString(1,"김철수");
	           pstmt.setString(2,"kimchulsu@test.com");
	           pstmt.setInt(3,25);
	           // SQl 실행
	          // executeUpdate() : insert,update delete시 사용
	          // executeQuery(): select시 사용
	           pstmt.executeUpdate();
	        
	           
	           System.out.println("추가성공");
	       
	        } catch (Exception e) {
	           System.out.println("연결 실패");
	           e.printStackTrace();
	        }
	
	
    

	
   
   
	}

}




