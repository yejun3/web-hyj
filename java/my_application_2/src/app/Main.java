package app;
import pack1.A;// ┐ my_module_a에서 가져옴
//import pack2.B;// ┘
import pack3.C;//my_module_b에서 가져옴
public class Main {
	public static void main(String[] args) {
	
	//my_module_a모듈의 클래스 이용
	A a = new A();
	a.method();
	
//	B b = new B();
//	b.method();
	
	
	//my_module_b 패키지에 포함된 C클래스 이용
	C c = new C();
	c.method();
	
	C result = a.getC();
	result.method();
}

}
