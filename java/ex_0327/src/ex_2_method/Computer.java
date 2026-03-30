package ex_2_method;

public class Computer  {
	public int sum(int ...values) {
	int sum =0;//지역변수 (이 함수에서만 영향력이 있음)
	           //return 이 없으면 연산결과를 끌어쓸 수 없음 
	           //return이 있으면 실행을 강제 종료하고 호출한 곳으로 돌아간다는 의미
	           // 매서드 내부로 끝난 결과를 확인할 때만 사용
	
	for(int x : values) {
		sum+=x;
	}
    // 값을 반환하는 경우
	//메서그 내부에서 계산을 끝내느 경우
	
	return sum;


}

}
