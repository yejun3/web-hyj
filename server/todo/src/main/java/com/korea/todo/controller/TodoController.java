package com.korea.todo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.todo.dto.ResponseDTO;
import com.korea.todo.dto.TodoDTO;
import com.korea.todo.entity.TodoEntity;
import com.korea.todo.service.TodoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor //@NonNull이나 final가진 필드에 대해서 매개변수를 갖는 생성자를 만들어준다.
@RequestMapping("todo")
public class TodoController {

	//TodoService를 필드로 갖고 객체를 생성자 주입을 한다.
	private final TodoService todoService;
	
	//생성자 주입
//	public TodoController(TodoService todoService) {
//		this.todoService = todoService;
//	}
	
	// /test 로 요청이 들어오면 testTodo라는 메서드가 실행되고
	//서비스의 메서드를 실행하여 응답으로 반환한다.
	//ResponseEntity : HTTP 응답 전체를 표현하는 객체
	@GetMapping("/test")
	public ResponseEntity<?> testTodo() {
		String str = todoService.testService();
		List<String> list = new ArrayList<>();
		list.add(str);
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		//ok() -> 상태를 강제로 200으로 설정한다.
		//body() -> 응답본문에 response 객체를 넣는다.
		//완성된 HTTP응답을 클라이언트에게 전송한다.
		return ResponseEntity.ok().body(response);
		
		//Controller -> Service -> ResponseDTO -> ResponseEntity -> JSON
	}
	
	@GetMapping("/todo")
	public ResponseEntity<?> retrieveTodoList() {
		try {
			// 1. 서비스의 retrieve() 메서드를 실행하여 전체 엔티티 리스트를 가져옴
			List<TodoEntity> entities = todoService.retrieve(null);
			
			// 2. 자바 스트림을 이용해 Entity 리스트를 안전한 응답용 DTO 리스트로 변환
			List<TodoDTO> dtos = entities.stream()
										 .map(TodoDTO::new)
										 .collect(Collectors.toList());
			
			// 3. 변환된 DTO 리스트를 공통 ResponseDTO에 담아서 반환
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
			
			// 4. HTTP Status 200 OK와 함께 응답 내보내기
			return ResponseEntity.ok().body(response);
			
		} catch (Exception e) {
			// 예외 발생 시 400 Bad Request 에러 반환
			String error = e.getMessage();
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
			return ResponseEntity.badRequest().body(response);
		}
	}
	
	//요청 -> (DTO -> Entity) TodoController -> TodoServce
	//추가하기 위해 데이터가 넘어왔다.
	//매개변수로 받는다.
	//엔티티로 변경하고 service로 보낸다.
	//비즈니스로직을 실행하고 난 결과를 받아온다.
	//응답으로 내보낸다.
	@PostMapping
	public ResponseEntity<?> createTodo(@RequestBody TodoDTO dto) {
		try {
			String temporaryUserId = "temporary-user"; // 임시 유저 아이디 (홑따옴표 ' -> 쌍따옴표 " 수정)
			
			// 1. DTO -> Entity 변환 (앞서 배운 toEntity 메서드 활용 또는 빌더 사용)
			TodoEntity entity = TodoDTO.toEntity(dto);
			
			// 2. 임시 유저 아이디 설정 (로그인 기능이 없으므로 하드코딩)
			entity.setUserId(temporaryUserId);
			
			// 3. 서비스 로직을 실행하고 결과를 Entity 리스트로 받아옴
			// 서비스레이어의 create 메서드를 호출하여, TodoEntity를 데이터베이스에 저장
			List<TodoEntity> entities = todoService.create(entity);
			
			// 4. 자바 스트림을 이용해 Entity 리스트를 다시 Response용 DTO 리스트로 변환
			List<TodoDTO> dtos = entities.stream()
										 .map(TodoDTO::new)
										 .collect(Collectors.toList());
			
			// 5. 변환된 DTO 리스트를 공통 ResponseDTO에 담아서 반환
			// 자바스트림을 이용해 반환된 엔티티 리스트를 TodoDTO타입의 리스트로 변환
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
			
			// 6. HTTP Status 200 OK와 함께 응답 내보내기
			return ResponseEntity.ok().body(response);
			
		} catch (Exception e) {
			// 7. 예외가 발생한 경우 에러 메시지를 ResponseDTO에 담아서 반환
			String error = e.getMessage();
			
			// 에러 메세지를 포함한 ResponseDTO 객체 만들기
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
			
			// HTTP Status 400 Bad Request와 함께 에러 응답 내보내기
			// badRequset() : 400 bad Requset 상태코드를 가진 응답 반환
			// 이는 클라이언트가 잘못된 요청을 했음을 나타낸다.
			return ResponseEntity.badRequest().body(response);
		}
	}
	
	// 1. 할 일 수정하기 (Update)
		@PutMapping
		public ResponseEntity<?> updateTodo(@RequestBody TodoDTO dto) {
			try {
				String temporaryUserId = "temporary-user"; // 임시 유저 아이디

				// ① 포스트맨이 보낸 DTO(가방)를 Entity(알맹이)로 변환
				TodoEntity entity = TodoDTO.toEntity(dto);
				entity.setUserId(temporaryUserId);

				// ② 서비스의 update 메서드를 실행하여 수정 후의 최신 리스트를 받아옴
				List<TodoEntity> entities = todoService.update(entity);

				// ③ 결과를 다시 응답용 DTO 리스트로 변환
				List<TodoDTO> dtos = entities.stream()
											 .map(TodoDTO::new)
											 .collect(Collectors.toList());

				// ④ 공통 응답 포맷(ResponseDTO)에 담아 200 OK로 반환
				ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
				return ResponseEntity.ok().body(response);

			} catch (Exception e) {
				// 예외 발생 시(예: 존재하지 않는 ID 수정 요청 등) 400 에러 반환
				String error = e.getMessage();
				ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
				return ResponseEntity.badRequest().body(response);
			}
		}

		// 2. 할 일 삭제하기 (Delete)
		@DeleteMapping
		public ResponseEntity<?> deleteTodo(@RequestBody TodoDTO dto) {
			try {
				String temporaryUserId = "temporary-user"; // 임시 유저 아이디

				// ① 삭제할 할 일의 ID 정보를 담은 Entity 변환
				TodoEntity entity = TodoDTO.toEntity(dto);
				entity.setUserId(temporaryUserId);

				// ② 서비스의 delete 메서드를 실행하여 삭제 후의 최신 리스트를 받아옴
				// (참고: 서비스 계층에 delete 메서드가 구현되어 있어야 합니다)
				List<TodoEntity> entities = todoService.delete(entity);

				// ③ 결과를 응답용 DTO 리스트로 변환
				List<TodoDTO> dtos = entities.stream()
											 .map(TodoDTO::new)
											 .collect(Collectors.toList());

				// ④ 공통 응답 포맷에 담아 200 OK로 반환
				ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
				return ResponseEntity.ok().body(response);

			} catch (Exception e) {
				// 예외 발생 시 400 에러 반환
				String error = e.getMessage();
				ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
				return ResponseEntity.badRequest().body(response);
			}
		}
}







