package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@Configuration : 해당 클래스가 설정파일임을 알려주는 용도
//@ComponentScan : 자동으로 컴포넌트 클래스를 검색하여 bean 클래스로 등록한다.
//ㄴ 현재 클래스가 들어있는 패키지 전부
//@EnableAutoConfiguration : 스프링의 다양한 설정이 자동으로 구성되고 완료됨
public class DemoApplication {

	public static void main(String[] args) {
		//main 메서드가 서버를 돌린다.
		SpringApplication.run(DemoApplication.class, args);
	}

}
