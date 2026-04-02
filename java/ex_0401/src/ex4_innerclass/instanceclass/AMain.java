package ex4_innerclass.instanceclass;

public class AMain {
	public static void main(String[] args) {
		//외부클래스의 객체
		A a = new A();
		// 인스턴스 내부 클래스의 개체 만들기 
		A.B b =a.new B();
		
		//인스턴스 내부 클래스의 객체만들기
		A.B b2 = a.useB();

		
	}

}
