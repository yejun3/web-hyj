package com.korea.movie_reservation.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.korea.movie_reservation.dao.MovieDAO;
import com.korea.movie_reservation.dao.ReservationDAO;
import com.korea.movie_reservation.vo.ReservationVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@RequestMapping("/movies")
public class ReservationService {
	private final ReservationDAO reservationDAO;
	private final MovieDAO movieDAO;

	public int insertReservation(ReservationVO vo) {
		return reservationDAO.insertReservation(vo);
	}
	
	

	public int updateReservation(ReservationVO vo, Integer id) {
		return reservationDAO.updateReservation(vo,id);
	}

	public List<ReservationVO> findReservationDetails() {
		return reservationDAO.findReservationDetails();
	}

}
