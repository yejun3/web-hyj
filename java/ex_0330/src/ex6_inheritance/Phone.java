package ex6_inheritance;

public class Phone {
	
	//상속 해주는 클래스 (부모클래스 , 슈퍼클래스등)
	//자식 클래스에게 필드, 메서드를  사용할 수 있도록 제공
	public String model;
	public String color;
	
	// 생성자가 정의되어있지 않으면 컴파일러가 기본생성자를 만들어준다.
	public Phone() {
		this.model = model;
		this.color = color;
		System.out.println("Phone() 생성자 실행 ");
	}
	
	// 사용작사 직접 정의하는 순간 기본생성자는 사라진다.
	
	public void bell () {
		System.out.println("벨이 울립니다.");
	}
	public void receiveMessage (String message) {
		System.out.println("상대방: " + message);
	}
	public void hangUp() {
		System.out.println("전화를 끊습니다.");
	}






}
