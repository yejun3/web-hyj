package com.korea.todo.service;

import org.springframework.stereotype.Service;
import com.korea.todo.entity.UserEntity;
import com.korea.todo.repository.UserRepository;
import lombok.RequiredArgsConstructor; // 1. 필수 추가
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor // 2. 필수 추가 (Repository 자동 주입)
public class UserService {
	
	private final UserRepository repository;
	
	// 회원가입 기능
	public UserEntity create(UserEntity user) {
		if(user == null || user.getUsername() == null) {
			throw new RuntimeException("Invalid arguments");
		}
		
		final String username = user.getUsername();
		
		// username이 이미 존재하는 경우, 경고 로그를 남기고 예외를 던진다.
		if(repository.existsByusername(username)) {
			log.warn("Username already exists: {}", username);
			throw new RuntimeException("Username already exists");
		}
		
		// 3. 수정: 검증 완료 후 진짜로 MySQL DB에 저장하고 그 결과를 리턴합니다!
		return repository.save(user);
	}
	
	//로그인 기능
	public UserEntity login(final String username, final String password) {
		return repository.findByUsernameAndPassword(username, password);
	}
}