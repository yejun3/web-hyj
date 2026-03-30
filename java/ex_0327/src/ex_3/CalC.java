package ex_3;

public class CalC {

	//직사각형의 넓이를 구하는 area 메서드를 작성하세요
	// 넓이는 메서드 내에서 출력하고 종료
	
	public void area(int a, int b){
		int x = a * b;
		System.out.println(x);
		
	}
	
	// 오버로딩 해서 정사각형의 넓이를 구하는 메서드 만들기
	// 길이는 매개변수로 받는다.
	//넓이는 반환받는다.
	public int area(int a) {
		return a * a;
		
	}
	
	
}
