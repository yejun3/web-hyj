package ex_final;

public class Korean {
	
	//final 필드는 초기값이 저장되면 이것이 최종적인 값이 되어서 프로그램 실행 도중에 수정할 수 없게 된다.
	//final 필드를 선언하는 두가지 방법
	
	//1. 선언과 동시에 값을 초기화한다.
	String nation = "대한민국";
	//객체마다 동일한 값을 갖고 있다면 필드 선언 시 초기값을 대입하는 것이 편하다.
	
	//2. 생성자를 호출하면서 매개변수로 값을 넘겨준다.
	//객체마다 다른 값을 가진다면 생성자에서 필드를 초기화 하는 것이 좋다.
	// 가능하면 초기화시킬 필드명과 동일한 이름을 사용하는 것이 좋다.
	final String ssn;
	String name;
	
	//생성자 생성
	public Korean(String ssn,String name) {
	this.ssn= ssn;
	this.name= name;
	}
	


	
}