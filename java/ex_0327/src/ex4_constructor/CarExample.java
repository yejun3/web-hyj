package ex4_constructor;

public class CarExample {
	public static void main(String[] args) {
		Car car1= new Car(); // 기본생성자만 호출
		
		Car car2 = new Car("자가용");//모델만 초기화하는 생성자 실행
		
		Car car3 = new Car("자가용","빨강");//모델, 색상만 초기화하는 생성자 실행
		
		Car car4 = new Car("자가용","빨강", 200);//모델, 색상, 최고속도를 초기화하는 생성자 실행
	}

}
