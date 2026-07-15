package com.korea.todo.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    // 이름을 받아 인사말 문장을 생성하는 비즈니스 로직
    public String getHelloMessage(String name) {
        return "안녕하세요, " + name + "님!";
    }
}
