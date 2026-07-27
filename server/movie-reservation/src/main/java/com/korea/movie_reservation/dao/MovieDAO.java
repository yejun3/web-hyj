package com.korea.movie_reservation.dao;

import org.apache.ibatis.annotations.Mapper;

import com.korea.movie_reservation.vo.MovieVO;

@Mapper
public interface MovieDAO {

	int insertMovie(MovieVO vo);

	MovieVO findMovieById(Integer id);

}
