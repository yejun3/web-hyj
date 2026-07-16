package com.korea.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.korea.todo.entity.BookEntity;

@Repository
// 스프링이 Bean으로 등록하여 Repository 계층으로 관리하도록 설정합니다.
//JpaRepository<상태 관리할 엔티티, 엔티티의 PK 타입>을 상속받습니다.
public interface BookRepository extends JpaRepository<BookEntity, Long>{

//	(데이터 접근 레이어)
//	역할: 데이터베이스에 접근하여 실제 SQL 쿼리를 실행하는 인터페이스입니다. 기본 CRUD는 자동으로 구현되며, 조건 검색만 직접 정의합니다.
    
	// 제목에 특정 문자열 포함
    List<BookEntity> findByTitleContaining(String title);
    // 인터페이스는 접근제한자는 항상 public이기 때문에 생략가능
    // 추상메서드 {실행내용}이 없는 껍데기 메서드 나중에 Jpa가 실행 내용을 알아서 채움
    //Title 컬럼에 있는 title을 포함한 데이터를 찾아서 가져와라(findBy), Containing은 앞뒤에 뭐가 붙어있든 title이 들어가 있으면 됨
    
    // 카테고리 일치
    List<BookEntity> findByCategory(String category);
    //Category 컬럼에 있는 category를 가진 데이터를 찾아서 가져와라(findBy)

}
