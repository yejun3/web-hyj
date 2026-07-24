package com.korea.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.jspecify.annotations.Nullable;

import com.korea.product.vo.ProductVO;

@Mapper
//DAO는 인터페이스로 생성 , Mapper를 해준다.
public interface ProductDAO {

	List<ProductVO> findAll();

	void insert(ProductVO vo);

	ProductVO findById(int productId);

	int update(ProductVO vo);

	int decreaseStock(int productId, int productCount);

}
