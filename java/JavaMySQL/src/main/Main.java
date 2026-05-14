package main;

import dao.MemberDAO;
import dto.MemberDTO;

public class Main {
	public static void main(String[]args) {
		// member 테이블의 모든 내용 조회하기

		// DAO 객체 생성
		MemberDAO dao = new MemberDAO();

		// 전체 조회 실행
		dao.findAll();
		//데이터 추가 실행
		dao.insert(new MemberDTO("박민수.","park@test.com",30));
		
		//데이터 추가 
		dao.update(40,9);
		
		//데이터 추가 삭제
         dao.delete(6);
         // 메서드를 만들 떄 값만 전달하는 방식과 객체 전달 방식(매개변수를 DTO로 씀)이 있다.
         

	}

}  
