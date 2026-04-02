package ex2_interface;

public class ExtendsMain {
	public static void main(String[] args) {
		InterfaceImpl impl = new InterfaceImpl();
		
		//인터페이스의 타입변환 
		//인터페이스와 구현클래스 사이에서 발생한다.
		// 자동타입변환 
		//구현객체를 인터페이스 탕빕변수에 대입할 때 자동타입변환이 일어남 
		
		
		//강제타입변환
		InterfaceA ia =impl;
		ia.methodA();
		//ia.methodB();
		//ia.methodC();
		
		InterfaceB ib =impl;
		//ib.methodA();
		ib.methodB();
		//ib.methodC();
		
		//다른 인터페이스를 상속받았기 때문에 전부 구현이 가능함
		InterfaceC ic = impl; 
		ic.methodA();
		ic.methodB();
		ic.methodC();
	
	}

}
