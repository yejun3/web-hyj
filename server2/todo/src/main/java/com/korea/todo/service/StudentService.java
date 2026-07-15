package com.korea.todo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.korea.todo.dto.StudentDTO;

@Service
public class StudentService {
	//1. 임시 메모리 데이터 베이스 역할의 ArrayList 생성
	private final List<StudentDTO> studentList = new ArrayList<>();
	private int idCounter = 1; // 수강생 번호를 자동으로 올려주기 위한 카운터 
	
	

	//2. 생성자에서 기본 수강생 2명을 미리 저장
	
	
	//  메서드를 호출해서 등록 -> 매서드호출: 매서드명(매개변수);
	public StudentService() {
		addStudent(StudentDTO.builder().name("김철수").course("스프링부트").email("kim@test.com").build());
		addStudent(StudentDTO.builder().name("이영희").course("스프링부트").email("yee@test.com").build());
	}
	

	//전체 수강생 목록 조회
	//매서드 생성 기본 형태 -> 접근제한자 반환형 메서드명(매개변수){실행코드}
	public List<StudentDTO> getStudents(){
		return studentList;
	}
	
	
	//수강생 등록 로직 
	//매서드 생성 기본 형태 -> 접근제한자 반환형 메서드명(매개변수)
	// 반환형이 있을 때는 return을 통해 값을 반환 void면 return을 쓰지 않는다.
	public StudentDTO addStudent(StudentDTO studentDTO) {
		//자동으로 ID 번호를 매겨서 리스트에 저장
		studentDTO.setId(idCounter++);
		studentList.add(studentDTO);
		return studentDTO; //저장된 학생 정보 반환
	}

}
