package com.korea.movie_reservation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.movie_reservation.service.ReservationService;
import com.korea.movie_reservation.vo.ReservationVO;

import lombok.RequiredArgsConstructor;

@RequestMapping("/reservations")
@RestController
@RequiredArgsConstructor
public class ReservationController {
	private final ReservationService reservationService;

	@PostMapping()
	public int insertReservation(@RequestBody ReservationVO vo) {
		return reservationService.insertReservation(vo);
	}
	
	@PutMapping("{reservationId}")
	public int updateReservation(@RequestBody ReservationVO vo, @PathVariable Integer id) {
		return reservationService.updateReservation(vo,id);
	}
	
	@GetMapping()
	public List<ReservationVO> findReservationDetails(){
		return reservationService.findReservationDetails();
	}
}
