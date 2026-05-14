package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.DBUtil;
import dto.CustomerDTO;

// 고객 추가 메서드
// insertCustomer(customer dto)
public class CustomerDAO {
	public void insertCustomer(CustomerDTO dto) {
		String sql = "insert into Customer(customer_id, name, phone) values (?,?,?)";
		try (
			Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
	    ){ 
			pstmt.setInt(1, dto.getCustomer_id());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPhone());
			pstmt.executeUpdate();
			System.out.println("추가 성공");
		
		} catch (Exception e) {
			System.out.println("추가 실패");
			e.printStackTrace();
		}
	 }

}
