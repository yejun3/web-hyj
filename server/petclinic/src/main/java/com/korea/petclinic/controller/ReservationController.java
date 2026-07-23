package com.korea.petclinic.controller;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.*;
import com.korea.petclinic.service.ReservationService;
import com.korea.petclinic.vo.ReservationVO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    // 문제 3: 모든 예약 정보 조회
    @GetMapping
    public List<ReservationVO> findAll() {
        return reservationService.findAll();
    }

    // 문제 4: 특정 예약 조회
    @GetMapping("/{id}")
    public ReservationVO findById(@PathVariable Long id) {
        return reservationService.findById(id);
    }

    // 문제 5: 새로운 예약 등록
    @PostMapping
    public int insert(@RequestBody ReservationVO reservation) {
        return reservationService.insert(reservation);
    }

    // 문제 6: 예약 정보 수정
    @PutMapping("/{id}")
    public int update(@PathVariable Long id, @RequestBody ReservationVO reservation) {
        reservation.setId(id); // URL의 id를 VO에 포함
        return reservationService.update(reservation);
    }

    // 문제 7: 예약 삭제
    @DeleteMapping("/{id}")
    public int delete(@PathVariable Long id) {
        return reservationService.delete(id);
    }

    // 문제 8: 검색 기준 선택 (/reservations/search-detail?searchType=pet&keyword=초코)
    @GetMapping("/search-detail")
    public List<ReservationVO> searchDetail(@RequestParam String searchType, @RequestParam String keyword) {
        return reservationService.searchDetail(searchType, keyword);
    }

    // 문제 9: 진료비 정렬 (/reservations/sort?sort=asc)
    @GetMapping("/sort")
    public List<ReservationVO> findAllOrder(@RequestParam String sort) {
        return reservationService.findAllOrder(sort);
    }

    // 문제 10: 상태별 예약 수 조회 (/reservations/status-count)
    @GetMapping("/status-count")
    public List<Map<String, Object>> findStatusCount() {
        return reservationService.findStatusCount();
    }
}