package com.example.demo23.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo23.service.BookService;
import com.example.demo23.vo.BookVO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    
    private final BookService bookservice;
    
    @GetMapping // 1: 전체 도서 조회
    public List<BookVO> findAll(){
        return bookservice.findAll();
    }
    
    @GetMapping("/{id}") // 2: 도서 번호를 이용한 단건 조회
    public BookVO findById(@PathVariable Long id) {
        return bookservice.findById(id); 
    }
    
    @PostMapping // 3: 도서 등록
    public int insert(@RequestBody BookVO book) {
        return bookservice.insert(book);
    }
    
    @PutMapping // 4: 도서 수정
    public int update(@RequestBody BookVO book) {
        return bookservice.update(book);
    }
    
    @DeleteMapping("/{id}") // 5: 도서 삭제
    public int delete(@PathVariable Long id) {
        return bookservice.delete(id);
    }
    
    @GetMapping("/category") // 6: 카테고리 도서 조회
    public List<BookVO> findByCategory(@RequestParam String category) {
        return bookservice.findByCategory(category);
    }
    
    @GetMapping("/search") // 7: 도서 제목 검색
    public List<BookVO> findByTitle(@RequestParam String title) {
        return bookservice.findByTitle(title);
    }
    
    @GetMapping("/price") // 8: 가격 이상의 도서 조회
    public List<BookVO> findByPrice(@RequestParam int minPrice) {
        return bookservice.findByPrice(minPrice);
    }
    
    @GetMapping("/count") // 9: 전체 도서 수량 조회 (/count 매핑으로 중복 해제)
    public int findCount(){
        return bookservice.findCount();
    }
    
    @GetMapping("/author") // 저자별 조회 추가
    public List<BookVO> findbyAuthor(@RequestParam(required = false) String author) {
        return bookservice.findbyAuthor(author);
    }
    
    @GetMapping("/sort/{sort}") // 정렬 조건 조회
    public List<BookVO> findAllOrder(@PathVariable String sort) {
        return bookservice.findAllOrder(sort);
    }
}