package com.korea.todo.controller;

import com.korea.todo.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    private final HelloService helloService;

    // 생성자 주입
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    // GET /api/hello?name=xxx 요청을 처리
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name") String name) {
        // 서비스로 이름을 전달하고 결과를 받아 반환
        return helloService.getHelloMessage(name);
    }
}

