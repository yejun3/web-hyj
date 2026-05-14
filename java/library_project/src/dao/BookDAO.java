package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBUtil;
import dto.BookDTO;


public class BookDAO {
	public void insertBook(BookDTO dto) {
	String sql = "insert into Book(book_id, title, author, stock) values (?,?,?,?)";
	try (
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);	
	){
		pstmt.setInt(1, dto.getBook_id());
		pstmt.setString(2, dto.getTitle());
		pstmt.setString(3, dto.getAuthor());
		pstmt.setInt(4, dto.getStock());
		pstmt.executeUpdate(); 
		System.out.println("추가 성공");
		
	} catch (Exception e) {
		System.out.println("추가 실패");
		e.printStackTrace();	
	}
 }

	//전체 도서 조회 기능 만들기
	   //findAllBooks()
	   public void findAllBooks() {
	      String sql = "SELECT * FROM book";
	      
	      try(
	         Connection conn = DBUtil.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         ResultSet rs = pstmt.executeQuery();
	            ){
	         while(rs.next()) {
	            int book_id = rs.getInt("book_id");
	            String title = rs.getString("title");
	            String author = rs.getString("author");
	            int stock = rs.getInt("stock");
	            
	            System.out.println("도서번호 : " + book_id );
	            System.out.println("도서명 : " + title);
	            System.out.println("저자 : " + author);
	            System.out.println("재고 : " + stock);
	            System.out.println("---------");
	         }
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }

  	 //재고 부족 도서 조회 
  	 // 재고가 2권 이하인 도서를 조회
  	 // findLowStockBooks()

	   public void findLowStockBooks() {
		      String sql = "SELECT * FROM book where stock <=2";
		      
		      try(
		         Connection conn = DBUtil.getConnection();
		         PreparedStatement pstmt = conn.prepareStatement(sql);
		         ResultSet rs = pstmt.executeQuery();
		            ){
		         while(rs.next()) {
		            int book_id = rs.getInt("book_id");
		            String title = rs.getString("title");
		            String author = rs.getString("author");
		            int stock = rs.getInt("stock");
		            
		            System.out.println("도서번호 : " + book_id );
		            System.out.println("도서명 : " + title);
		            System.out.println("저자 : " + author);
		            System.out.println("재고 : " + stock);
		            System.out.println("---------");
		         }
		         
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		   }




}
