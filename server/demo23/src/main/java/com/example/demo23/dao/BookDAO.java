package com.example.demo23.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.example.demo23.vo.BookVO;

@Mapper
public interface BookDAO {
    
    List<BookVO> findAll();
    
    BookVO findById(Long id);
    
    int insert(BookVO book);
    
    int update(BookVO book);
    
    int delete(Long id);

    List<BookVO> findByCategory(String category);
    
    List<BookVO> findByTitle(String title);
    
    List<BookVO> findByPrice(int minPrice);
    
    int findCount();
    
    List<BookVO> findbyAuthor(String author);
    
    List<BookVO> findAllOrder(String sort);
}