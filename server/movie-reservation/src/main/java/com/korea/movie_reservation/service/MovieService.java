package com.korea.movie_reservation.service;

import org.springframework.stereotype.Service;

import com.korea.movie_reservation.dao.MovieDAO;
import com.korea.movie_reservation.vo.MovieVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {
	private final MovieDAO movieDAO;
	
	public int insertMovie(MovieVO vo) {
		return movieDAO.insertMovie(vo);
	}
	
	public MovieVO findMovieById(Integer id) {
		return movieDAO.findMovieById(id);
	}



}
