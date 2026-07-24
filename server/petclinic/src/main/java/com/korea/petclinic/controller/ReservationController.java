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

    // insert,update,delete 쿼리를 실행하고난 결과 -> 이 쿼리를 실행하고 나서 행의 갯수 -> 반환형이 int
    // 영향을 받은 행의 개수를 반환
    // 문제 6: 예약 정보 수정
//    @PutMapping("/{id}")
//    public int update(@PathVariable Long id, @RequestBody ReservationVO vo) {
//     vo.setId(id); 
//     return reservationService.update(vo);
//    }
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

    //검색 기준을 선택하여 조회하기
    //사용자가 전달한 searchType 값에 따라 다른 기준으로 예약정보 검색하기
    //사용가능한 검색 기준
    //pet : 반려동물 이름을 통한 검색
    //owner : 보호자 이름을 통한 검색
    //doctor : 담당 수의사 이름을 통한 검색 
    
    //("/@RequestMapping요청주소/@GetMapping 요청주소? 키=키에 해당하는 데이터&값=값에 해당하는 데이터")
    // public List<vo> 매서드명(@RequsetParam /키 변수타입/ 키 변수명 , @RequsetParam /값의 타입/ 값의 변수명)
 
    // 문제 8: 검색 기준 선택 (/reservations/search-detail?searchType=pet&keyword=초코)
    @GetMapping("/search-detail")
    public List<ReservationVO> searchDetail(@RequestParam String searchType, @RequestParam String keyword) {
        return reservationService.searchDetail(searchType, keyword);
    }
    
    //진료 예약 정보를 예상 진료비 순으로 정렬 
    //사용자가 sort값을 전달 
    
    // 문제 9: 진료비 정렬 (/reservations/sort?sort=asc)
    @GetMapping("/sort")
    public List<ReservationVO> findAllOrder(@RequestParam(required=false) String sort) {
        return reservationService.findAllOrder(sort);
    }

    // 문제 10: 상태별 예약 수 조회 (/reservations/status-count)
    @GetMapping("/status-count")
    public List<Map<String, Object>> findStatusCount() {
        return reservationService.findStatusCount();
    }
    
    // 전체 예상 진료비 
    //GET / reservation/total-price
    
    @GetMapping("/total-price")
    public Integer amountprice(){
    	return reservationService.amountprice();
    }
    
    //예약 상태별 갯수 출력
    //GET /reservations/status-count
    
    
}