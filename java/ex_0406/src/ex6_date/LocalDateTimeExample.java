package ex6_date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeExample {
	public static void main(String[] args) {
		//java8 이후에 등장한 현대적ㅇ니 날짜 API
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		
		//원하는 날짜와 시간을 직접 만들기
		LocalDateTime dateTime = LocalDateTime.of(2026, 4,6,10,30);
		System.out.println(dateTime);
	
	
	//날짜/시간 전체를 알고있기 때문에 
		//연도 ,월, 일, 시, 분 등을 꺼낼수있다.
	
	System.out.println("연도: " + now.getYear());
	System.out.println("월: " + now.getMonth());
	System.out.println("일: " + now.getDayOfMonth());
	System.out.println("시: " + now.getHour());
	System.out.println("분: " + now.getMinute());
	System.out.println("초: " + now.getSecond());
	
	//날짜와 시간 더하기 빼기
	//일 더하기 
	System.out.println("10일 뒤 : " + now.plusDays(10));
	System.out.println("2달뒤: " + now.plusMonths(2));
	
	//년 더하기 : plusYears
	
	//빼기: minusDay, minusMonth...
	
	
	//문자열로 출력형식 바꾸기
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년,MM월,dd일 HH시 mm분 ss시");
	String result = now.format(formatter);
	System.out.println(result);
	
	//문자열을 LocalDateTime으로 바꾸기
	//String str = "2026/04/06/ 16:37";
	//formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
	//LocalDateTime dateTime2 = LocalDateTime.parse(str, formatter);
			
	//System.out.println(dateTime2);
	
	//게시글 작성시간
	//회원가입시간
	//주문생성시간 예약시간 마감시간 등 시간이 사용되는 대부분 사용
	
	//날짜비교 가능
	//isbefore() :앞선 시간인지 비교
	//isAfter() : 뒤의 시간인지 비교
	LocalDateTime meeting = LocalDateTime.of(2026,4,10,14,0);
	System.out.println(now.isBefore(meeting));
	System.out.println(now.isAfter(meeting));
	// 같은지 보려면 overriding된 isEqual 사용
	System.out.println(now.isEqual(meeting));
	
	//날짜의 특정 부분만 바꾸기
	//이미 만들어진 날짜/시간 객체에서 
	//연도나 월,일 , 시를 바꾼 새로운 객체를 만들 수 있다.
	LocalDateTime chaged = now.withYear(2030).withMonth(12)
			.withDayOfMonth(25).withHour(9);
	 
	System.out.println(now); 
	System.out.println(chaged);
	
	
	
	
	//현재 시간이 09:00 ~ 18:00사이인지 확인하여
	//예약 가능 여부를 츨력하세요
	
	LocalDateTime start = now
			.withHour(9)
			.withMinute(0)
			.withSecond(0);

LocalDateTime end = now
			.withHour(18)
			.withMinute(0)
			.withSecond(0);

// 시간비교(isAfter, isBefore 활용)
if (now.isAfter(start) && now.isBefore(end)) {
System.out.println("예약이 가능합니다.");
}
else {
System.out.println("예약이 불가합니다.");
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
			
	
	
	
	
	}

	

	}
