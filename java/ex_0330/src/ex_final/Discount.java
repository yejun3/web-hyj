package ex_final;

public class Discount {
 
    int amout;
	static final double discount1 = 0.2; 
	static final double discount2 = 0.1;
	static final double discount3 = 0.05;
	
	public double  calculatediscount(int price) {
		if(price>100000) {
			return discount1;
		}else if(price>50000) {
			return discount2;
		}else if(price<50000) {
			return discount3;
		}else {
			return -1;
		}
	}
	
	// 금액별 할일률이 적용된 금액을 반환하는 메소드 작성
	// 메서드 내부에서 호출 할 수 있다.
	public int  calculatePrice(int price){
		double rate = calculatediscount(price);
			return (int)(price - (price*rate));	
	}
}
