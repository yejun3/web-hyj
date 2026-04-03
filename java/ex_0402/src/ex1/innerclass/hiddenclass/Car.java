package ex1.innerclass.hiddenclass;

public class Car {
	
	private Tire tire1 = new Tire();
	
	private Tire tire2 = new Tire() {
		//익명클래스
		@Override
		public void roll(){
			System.out.println("오버라이딩 된 타이어가 굴러갑니다.");
		}
	};
	
	//1. 메소드를 이용
	public void run1() {
		tire1.roll();
		tire2.roll();
	}

	//2. 로컬 변수에 익명 자식 객체 대입
	public void run2() {
		Tire tire = new Tire() {
			@Override
			public void roll() {
				System.out.println(" 굴러갑니다.");
			}
		};
		tire.roll();
	}

	//3.매개변수로 이용
	public void run3(Tire tire) {
		tire.roll();
	}
		
	
}
