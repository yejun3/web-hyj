package com.korea.todo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity //"이 Java 클래스를 MySQL 테이블과 연결하겠다"
@Table(name = "book") //이 클래스는 MySQL의 book 테이블과 연결

public class BookEntity { // (데이터베이스 테이블과 매핑하는 클래스)
	
	@Id // PK지정
	@GeneratedValue(strategy = GenerationType.IDENTITY)// id 번호는 내가 넣지 않고 DB가 자동 증가시킴
	private Long id;
	
	@Column(nullable=false) //조건을 부여함
	private String title;
	@Column(nullable=false)
	private String author;
	private int price;
	private String category;
	private int stock;
	
}
