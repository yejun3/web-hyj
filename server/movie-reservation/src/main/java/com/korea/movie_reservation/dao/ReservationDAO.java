package com.korea.movie_reservation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korea.movie_reservation.vo.ReservationVO;

@Mapper
public interface ReservationDAO {

	int insertReservation(ReservationVO vo);

	int updateReservation(ReservationVO vo, Integer id);

	List<ReservationVO> findReservationDetails();
}
