package com.korea.todo.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.korea.todo.dto.ResponseDTO;
import com.korea.todo.dto.StudentDTO;
import com.korea.todo.service.StudentService;

@RestController
@RequestMapping("api/students")
public class StudentController {

    private final StudentService studentService;

    // 생성자 주입
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // 1. 수강생 목록 조회 (GET /api/students)
    //<?> :와일드카드 어떤 타입의 데이터든 올수있게 유연성을 줌
    @GetMapping //프론트엔드에서 fetch를 통해 데이터를 달라고 요청하면 건네줌
    public ResponseEntity<?> getStudents() {
    	try {
    	       List<StudentDTO> students = studentService.getStudents();
    	        
    	        // ResponseDTO 포장상자에 데이터를 담습니다.
    	        ResponseDTO<StudentDTO> response = ResponseDTO.<StudentDTO>builder()
    	        		.error(null)
    	                .data(students)
    	                .build();
    	         
    	        return ResponseEntity.ok().body(response);
			
		} catch (Exception e) {
	        ResponseDTO<StudentDTO> response = ResponseDTO.<StudentDTO>builder()
	        		.error("수강생 목록 조회를 실패했습니다.")
	                .build();
	        return ResponseEntity.ok().body(response);
		}
 
    }
    
    //@RequsetBody : 클라이언트가  HTTP 요청의 Body(본문)에 담아 보낸 데이터를
    // Java 객체로 자동으로 만들어줌

    // 2. 수강생 등록 (POST /api/students)
    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody StudentDTO studentDTO) {
        // 주방장에게 수강생 등록을 지시합니다.
        StudentDTO savedStudent = studentService.addStudent(studentDTO);
        
        // 단 한 명의 등록 정보를 담아서 리스트 형태로 포장합니다.
        
        
        
        
        List<StudentDTO> list = List.of(savedStudent);
        ResponseDTO<StudentDTO> response = ResponseDTO.<StudentDTO>builder()
                .data(list)
                .build();
                
        return ResponseEntity.ok().body(response);
    }
}