package ex_3;

public class Main {
	public static void main(String[] args) {
		OverloadingExample o = new OverloadingExample();
		
		//매서드 오버로딩의 장점
		// 같은 이름으로 여러가지 타입의 매개값을 처리할 수 있다.
		int result = o.plus(1, 2);
		double result2 = o.plus(1.0, 2.0);
		System.out.println(result);
		System.out.println(result2);
		
		
	 CalC a = new CalC();
	 a.area (4,5);
	
	//객체를 정의한 클래스명 + 객체를 지정할 변수  new 클래스명();
	 // 객체를 통한 메서드 호출
	 // -> 객체를 지정한 변수.매서드명(매개변수에 넣을 값);
	 
	 CalC r = new CalC();
	int squre= r.area (3);
	System.out.println(squre);
	 

	}

}
