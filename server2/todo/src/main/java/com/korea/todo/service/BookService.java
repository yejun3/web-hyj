package com.korea.todo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.korea.todo.dto.BookDTO;
import com.korea.todo.entity.BookEntity;
import com.korea.todo.repository.BookRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
	//서비스는 비즈니스 기능을 정의합니다. Repository를 활용해 DB에서 엔티티를 꺼내온 후, DTO로 변환하여 Controller로 넘깁니다.
    //포스트맨에서 dto데이터를 controller가 받고 이를 그대로 service에게 넘김
	//dto데이터를 entity객체형태로 바꾼후 repository를 이용해 DB의 데이터를 조회하고 가져옴 
	//그리고 가져오 데이터로 재조립하여 DTO로 포장시킨후 Controller에게 반환함
    private final BookRepository repository;

    // 1. 도서 등록
    @Transactional   // 데이터를 삽입하므로 쓰기 전용 트랜잭션을 적용합니다.
    public BookDTO create(BookDTO dto) {
    	// 클라이언트가 보낸 DTO 데이터를 DB에 넣기 위해 Entity 객체로 빌드합니다.
    	//포스트맨으로 부터 DTO형태의 데이터를 받고 이를 객체형태로 풀어내서 데이터를 받음
        BookEntity entity = BookEntity.builder()
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .price(dto.getPrice())
                .category(dto.getCategory())
                .stock(dto.getStock())
                .build();

        //데이터를 받아서 조립한 객체를 다시 DTO형태로 포장해서 controll에게 반환
        return new BookDTO(repository.save(entity));
    }

    // 2. 전체 조회
    public List<BookDTO> findAll() {

        return repository.findAll()
                .stream()
                .map(BookDTO::new)
                .collect(Collectors.toList());
    }

    // 3. ID 조회
    public BookDTO findById(Long id) {

        BookEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("도서를 찾을 수 없습니다."));

        return new BookDTO(entity);
    }

    // 4. 제목 검색
    public List<BookDTO> findByTitle(String title) {

        return repository.findByTitleContaining(title)
                .stream()
                .map(BookDTO::new)
                .collect(Collectors.toList());
    }

    // 5. 카테고리 검색
    public List<BookDTO> findByCategory(String category) {

        return repository.findByCategory(category)
                .stream()
                .map(BookDTO::new)
                .collect(Collectors.toList());
    }

    // 6. 수정
    public BookDTO update(Long id, BookDTO dto) {

        BookEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("도서를 찾을 수 없습니다."));

        entity.setTitle(dto.getTitle());
        entity.setAuthor(dto.getAuthor())
        
        ;
        entity.setPrice(dto.getPrice());
        entity.setCategory(dto.getCategory());
        entity.setStock(dto.getStock());

        return new BookDTO(repository.save(entity));
    }

    // 7. 삭제
    public void delete(Long id) {

        repository.deleteById(id);
    }

}
