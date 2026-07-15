package com.korea.todo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//http응답으로 사용할 DTO 
//클라이언트(프론트엔드)에게 응답(에러 메시지, 결과 데이터 목록)을 
//보내기 위해서 응답을 담을 객체를 만들기 위한 클래스

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseDTO<T> {
	private String error; // 에러 발생 시 담을 메시지
	private List<T> data; //다른 엔티티들도 ResponseDTO를 이용해 
	// 반환할 수 있도록 제네릭을 사용한다.	
	
}
