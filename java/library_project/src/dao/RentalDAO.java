package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBUtil;

public class RentalDAO {
	//고객이 도서를 대여하면 다음의 작업을 처리한다.
	//도서 재고를 조회 
	// retal 테이블에 대여 정보를 추가
	// book 테이블의 재고를 1 감소
	// rentalBook(int custmoerId, int bookId)
	
	// conn.rollback();
	// conn.commit();

	public void rentalBook(int customerId, int bookId) {

	    String selectSQL = "select stock from book where book_id = ?";
	    String insertSQL = "insert into rental(customer_id, book_id, rental_date) values(?,?,now())";
	    String updateSQL = "update book set stock = stock - 1 where book_id = ?";

	    try (Connection conn = DBUtil.getConnection()) {

	        conn.setAutoCommit(false);

	        // 1. 재고 확인
	        try (PreparedStatement pstmt1 = conn.prepareStatement(selectSQL)) {
	            pstmt1.setInt(1, bookId);

	            try (ResultSet rs = pstmt1.executeQuery()) {
	                if (!rs.next() || rs.getInt("stock") <= 0) {
	                    System.out.println("재고 없음");
	                    conn.rollback();
	                    return;
	                }
	            }
	        }

	        // 2. 대여 insert
	        try (PreparedStatement pstmt2 = conn.prepareStatement(insertSQL)) {
	        	pstmt2.setInt(1, customerId);
	        	pstmt2.setInt(2, bookId);
	            pstmt2.executeUpdate();
	        }

	        // 3. 재고 감소
	        try (PreparedStatement pstmt3 = conn.prepareStatement(updateSQL)) {
	            pstmt3.setInt(1, bookId);
	            pstmt3.executeUpdate();
	        }

	        conn.commit();
	        System.out.println("대여 완료");

	    } catch (Exception e) {
	        System.out.println("대여 실패");
	        e.printStackTrace();
	    }
	}
// 전체대여목록 join으로 조회
// 대여번호,고객명,제목 대여일조회
// 매서드명  findRentalList()
	public void findRentalList() {
	      String sql = """ 
	            select
	               r.rental_id,
	               c.name,
	               b.title,
	               r.rental_date
	            from rental r
	            INNER JOIN customer c
	            ON r.customer_id = c.customer_id
	            INNER JOIN book b
	            ON r.book_id = b.book_id
	            ORDER BY r.rental_id
	            """;
	      try (
	         Connection conn = DBUtil.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         ResultSet rs = pstmt.executeQuery();
	      ){
	         while(rs.next()) {
	            System.out.println("대여번호 : " + rs.getInt("rental_id"));
	            System.out.println("고객명 : " +  rs.getString("name"));
	            System.out.println("도서명 : " + rs.getString("title"));
	            System.out.println("대여일 : " + rs.getString("rental_date"));
	            System.out.println("-----------------");
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }

	}

	 // 고객 id를 입력받아서 고객명, 제목, 빌린날짜 순으로 출력하기
	public void findCustomerRentalList(int rental_customerId) {
	      String sql = """ 
	            select
	               c.name,
	               b.title
	               r.rental_date
	            from rental r
	            INNER JOIN customer c
	            ON r.customer_id = c.customer_id
	            INNER JOIN book b
	            ON r.book_id = b.book_id
	            where customer_id = ?
	            """;
	      try (
	         Connection conn = DBUtil.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	      ){
	    	  pstmt.setInt(1, rental_customerId);
	    	  pstmt.executeUpdate();
	    	  
	    	  ResultSet rs = pstmt.executeQuery();
	    	  boolean found = false;
	    	  
	         while(rs.next()) {
	            System.out.println("고객명 : " +  rs.getString("name"));
	            System.out.println("제목 : " + rs.getString("title"));
	            System.out.println("대여일 : " + rs.getString("rental_date"));
	            System.out.println("-----------------");
	         }
	         
	         // 조회된게 없다면
	         if(!found) {
	        	 System.out.println("대여 내력이 없습니다.");
	         }
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }






	}
}

