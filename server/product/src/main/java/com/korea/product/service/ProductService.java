package com.korea.product.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import com.korea.product.dao.ProductDAO;
import com.korea.product.vo.ProductVO;

import lombok.RequiredArgsConstructor;

@Service //어노테이션 꼭 필요
@RequiredArgsConstructor
public class ProductService {
	// 의존성 주입을 해주어야 한다.
	private final ProductDAO productDAO;
	
	//전체 조회
	public List<ProductVO> findAll() {
		return productDAO.findAll();
	}

	// 상품 등록
	public List<ProductVO> insert(ProductVO vo) {
		productDAO.insert(vo);
		
		return productDAO.findAll();
	}

	//상품 단일 검색
	public ProductVO findById(int productId) {
		return productDAO.findById(productId);
	}

	//상품 정보 수정
	public List<ProductVO> update(ProductVO vo) {
		//제품이 있는지 확인
		ProductVO product = productDAO.findById(vo.getProductId());
		
		if(product == null) {
			throw new IllegalArgumentException("수정할 상품이 존재하지 않습니다.");
		}
		
		productDAO.update(vo);
		
		return productDAO.findAll();
	}

}
