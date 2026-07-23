package com.korea.todo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.todo.dto.ResponseDTO;
import com.korea.todo.dto.UserDTO;
import com.korea.todo.entity.UserEntity;
import com.korea.todo.security.TokenProvider;
import com.korea.todo.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserController {
	
	private final UserService userService;
	/////////////////////////////////////////////////////
	private final TokenProvider tokenProvider; //의존성주입
	///////////////////////////////////////////////////
	// 회원 가입 요청 처리
	@PostMapping("/signup")
	public ResponseEntity<?> resisterUser(@RequestBody UserDTO dto){
		try {
			// 1. 클라이언트가 보낸 DTO 데이터로 DB 저장용 엔티티 객체 생성
			UserEntity userEntity = UserEntity.builder()
					.username(dto.getUsername())
					.password(dto.getPassword())
					.build();
			
			// 2. 서비스 레이어에 비즈니스 로직(중복 검사 및 DB 저장) 위임
			UserEntity registeredUser = userService.create(userEntity);
			
			// 3. 보안과 안전한 반환을 위해 결과 데이터 중 필요한 정보만 골라 응답 DTO에 매핑
			UserDTO responseUserDTO = UserDTO.builder()
			                             .id(registeredUser.getId()) 
			                             .username(registeredUser.getUsername())
			                             .build();
			
			// 4. 성공 시 200 OK와 함께 회원 정보 응답
			return ResponseEntity.ok(responseUserDTO);
			
		} catch (Exception e) {
			// 실패 시 예외 메시지를 담아 400 Bad Request 응답
			ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
			return ResponseEntity.badRequest().body(responseDTO);
		}
	}
	
	//@RequsetBody
	//HTTP 요청의 Body에 담아 보낸 데이터를 Java객체로 변환하여
	// 컨트롤러의 매개변수로 받기 위한 어노테이션
	//POST, PUT 요청으로 JSON 데이터를 받을 때 많이 사용한다.
	
	//로그인 하기 
	//경로 POST /signin
	//메서드명 authenticate
	//입력받은 아이디와 비밀번호를 받아서 검증하고 조회된 유저를 반환
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticate(@RequestBody UserDTO dto) {
	    // 1. 서비스에게 아이디와 비밀번호를 던져서 DB에 존재하는 회원인지 확인합니다.
	    UserEntity user = userService.login(dto.getUsername(), dto.getPassword());

	    // 2. 일치하는 회원이 존재한다면 (로그인 성공!)
	    if (user != null) {
	    	///////////////////////////////////////////////////////
	    	final String token = tokenProvider.create(user);
	    	////////////////////////////////////////////////////
	        // 포스트맨에게 돌려줄 응답용 DTO 접시를 만듭니다.
	        final UserDTO responseUserDTO = UserDTO.builder()
	                .id(user.getId())
	                .username(user.getUsername())
	                ////////////////
	                .token(token)
	                //////////////
	                .build();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 

	        return ResponseEntity.ok(responseUserDTO); // 200 OK
	    } 
	    // 3. 일치하는 회원이 없다면 (로그인 실패!)
	    else {
	    	//유저가 존재하지 않거나 인증 실패 시 에러 메세지를 포함한 ResponseDTO를 반환
	        ResponseDTO responseDTO = ResponseDTO.builder()
	                .error("Login failed. Invalid username or password.")
	                .build();

	        return ResponseEntity.badRequest().body(responseDTO); // 400 Bad Request
	    }
	}
	
}