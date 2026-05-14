package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.DBUtil;
import dto.MemberDTO;

// **DAO (Data Access Object)**
// 실제 DB에 접근해서 SQL 실행하는 클래스
public class MemberDAO {

	// 조회 (전체 회원 목록)
	public void findAll() {
		//member 테이블에서 데이터를 조회한 후 memberDTO 객체를 담은 후 
		//콘솔에 출력하는 코드 작성하기

		// SQL 작성
		String sql = "select * from member";

		// DB 결과를 담을 리스트 (여러 명 저장)
		List<MemberDTO> list = new ArrayList<>();

		try (
			// DB 연결
			Connection conn = DBUtil.getConnection();
			// SQL을 실행할 실행 객체
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// SQL 결과 저장 객체
			ResultSet rs = pstmt.executeQuery();
		) {

			// 한 줄씩 읽기 반복
			while (rs.next()) {
				// DB → DTO로 데이터 이동
				MemberDTO dto = new MemberDTO(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("email"),
						rs.getInt("age")
				);

				// 리스트에 저장
				list.add(dto);
			}

			// 출력
			for (MemberDTO m : list) {
				System.out.println(m);
			}

		} catch (Exception e) {
			System.out.println("조회 실패");
			e.printStackTrace();
		}
	}

	// 추가 (INSERT)
	public void insert(MemberDTO dto) {
		// 매개변수를 통해 넘겨받은 dto를 member 테이블에 추가하기
		String sql = "insert into member(name,email,age) values (?,?,?)";

		try (// 소괄호 안에는 close()를 해줘야 하는 것들을 씀
			Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);	   
		) {
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setInt(3, dto.getAge());

			int result = pstmt.executeUpdate();

			System.out.println(result + "회원 추가 성공");

		} catch (Exception e) {
			System.out.println("추가 실패");
			e.printStackTrace();
		}
	}

	// 수정 (UPDATE)
	// 특정 사람의 나이를 수정하는 메서드 작성하기
	public void update(int age,int id) {

		String sql = "update member set age=? where id=?";

		try (
			Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {

			pstmt.setInt(1,age);
			pstmt.setInt(2,id);

			pstmt.executeUpdate();

			System.out.println("수정 성공");

		} catch (Exception e) {
			System.out.println("수정 실패");
			e.printStackTrace();
		}
	}

	// 삭제 (DELETE)
	public void delete(int id) {

		String sql = "delete from member where id=?";

		try (
			Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {

			pstmt.setInt(1,id);

			pstmt.executeUpdate();

			System.out.println("삭제 성공");

		} catch (Exception e) {
			System.out.println("삭제 실패");
			e.printStackTrace();
		}
	}
}
