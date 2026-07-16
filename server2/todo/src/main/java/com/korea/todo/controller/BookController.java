package com.korea.todo.controller;

import java.util.Collections;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.korea.todo.dto.BookDTO;
import com.korea.todo.dto.ResponseDTO;
import com.korea.todo.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    // 1. 등록
    @PostMapping
    public ResponseEntity<?> create(@RequestBody BookDTO dto){

    	//bookService.create(dto);
    	
        ResponseDTO<BookDTO> response = ResponseDTO.<BookDTO>builder()
                .data(Collections.singletonList(service.create(dto)))
                .build();

        return ResponseEntity.ok().body(response);
    }

    // 2. 전체 조회
    @GetMapping
    public ResponseEntity<?> findAll(){

        ResponseDTO<BookDTO> response = ResponseDTO.<BookDTO>builder()
                .data(service.findAll())
                .build();

        return ResponseEntity.ok().body(response);
    }

    // 3. ID 조회
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        ResponseDTO<BookDTO> response = ResponseDTO.<BookDTO>builder()
                .data(Collections.singletonList(service.findById(id)))
                .build();

        return ResponseEntity.ok().body(response);
    }

    // 4. 제목 검색
    @GetMapping("/title")
    public ResponseEntity<?> findByTitle(@RequestParam String keyword){

        ResponseDTO<BookDTO> response = ResponseDTO.<BookDTO>builder()
                .data(service.findByTitle(keyword))
                .build();

        return ResponseEntity.ok().body(response);
    }

    // 5. 카테고리 검색
    @GetMapping("/category")
    public ResponseEntity<?> findByCategory(@RequestParam String category){

        ResponseDTO<BookDTO> response = ResponseDTO.<BookDTO>builder()
                .data(service.findByCategory(category))
                .build();

        return ResponseEntity.ok().body(response);
    }

    // 6. 수정
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody BookDTO dto){

        ResponseDTO<BookDTO> response = ResponseDTO.<BookDTO>builder()
                .data(Collections.singletonList(service.update(id, dto)))
                .build();

        return ResponseEntity.ok().body(response);
    }

    // 7. 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        service.delete(id);

        ResponseDTO<BookDTO> response = ResponseDTO.<BookDTO>builder()
                .error(null)
                .data(null)
                .build();

        return ResponseEntity.ok().body(response);
    }

}