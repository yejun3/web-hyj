package com.korea.todo.dto;

import com.korea.todo.entity.BookEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 롬복: Getter, Setter, toString 등을 자동 완성합니다. 
// 기존에는 자바의 캡슙화 떄문에 다른 장소에서 객체데이터를 꺼내 쓰려면 setter getter를 써야 했지만 그런 필요 없어짐
@NoArgsConstructor // 롬복: 매개변수가 없는 기본 생성자 BookDTO() { }를 자동 생성합니다.
@AllArgsConstructor // 롬복: 모든 필드를 채우는 생성자 BookDTO(id, title, author, ...)를 자동 생성합니다.
@Builder // 롬복: 빌더 패턴(안전한 조립기)을 사용하여 객체를 생성할 수 있게 돕습니다.
public class BookDTO {

	// 1. 데이터를 담을 필드(변수) 선언 부분
	private Long id;
	private String title;
	private String author;
	private int price;
	private String category;
	private int stock;

	// 2. [생성자] : 진짜 데이터(Entity)가 들어오면 그걸 뜯어서 DTO 상자에 담아주는 생성자입니다.
	// 데이터를 DTO라는 틀 안에 넣는 기능을 함 (특수 메서드)
	// 호출 예시: BookDTO dto = new BookDTO(entity);
	// 접근제한자  클래스명( 전달받을데이터타입 매개변수명 )
	public BookDTO(BookEntity entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.author = entity.getAuthor();
		this.price = entity.getPrice();
		this.category = entity.getCategory();
		this.stock = entity.getStock();
	}
}
