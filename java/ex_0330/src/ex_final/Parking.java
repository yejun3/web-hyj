package ex_final;

public class Parking {
    // 기본요금 : 10,000(상수)
	//추가 요금 : 시간 당 2,000(상수)
	//요금계산 매서드
	static final int BASE_FEE = 10000;
	static final int EXTRA_FEE= 2000;
	int time;
	
	public int caculate(int time) {
	return (int)(BASE_FEE+(EXTRA_FEE*time));
		}
}
