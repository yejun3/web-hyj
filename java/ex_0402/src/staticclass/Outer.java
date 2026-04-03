package staticclass;

// 정적 내부 클래스를  쓰는 이유
public class Outer {
	int a =10; // 일반 필드 (멤버변수)
	static int b = 20; //정적 필드(클래스변수)
	
	//바깥 클래스와 완전히 단절된 것은 아니고, 필요하면 객체를 전달받아 사용할 수 있다.
	static class Inner{
		// 정적 내부 클래스는 Outer 객체에 연결되어 있지 않기 떄문이다.
		void print () {
			//System.out.println(a);오류
			System.out.println(b);//가능	
		}
		void print (Outer outer) {
			System.out.println(outer.a);
	    }
	}
}
