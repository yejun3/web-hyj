package com.example.demo23.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo23.dao.BookDAO;
import com.example.demo23.vo.BookVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
    
    private final BookDAO bookDAO;
    
    public List<BookVO> findAll(){
        return bookDAO.findAll();
    }

    public BookVO findById(Long id) {
        return bookDAO.findById(id);
    }
    
    public int insert(BookVO book) {
        return bookDAO.insert(book);
    }
    
    public int update(BookVO book) {
        return bookDAO.update(book);
    }
    
    public int delete(Long id) {
        return bookDAO.delete(id);
    }
    
    public List<BookVO> findByCategory(String category) {
        return bookDAO.findByCategory(category);
    }
    
    public List<BookVO> findByTitle(String title) {
        return bookDAO.findByTitle(title);
    }
    
    public List<BookVO> findByPrice(int minPrice) {
        return bookDAO.findByPrice(minPrice);
    }
    
    public int findCount() {
        return bookDAO.findCount();
    }

    public List<BookVO> findbyAuthor(String author) {
        return bookDAO.findbyAuthor(author);
    }
    
    public List<BookVO> findAllOrder(String sort) {
        return bookDAO.findAllOrder(sort);
    }
}