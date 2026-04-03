package ex_1_exception.throwsexample;

public class ThrowsExample {
	public static void main(String[] args) {
		try {
			findClass();
		} catch (Exception e) {
			System.out.println("예외처리 : " + e.toString());
		}
	}

	// 나열해야 하는 예외클래스가 많은 경우 throwException 도는 throwable로
	//모든 예외를 간단히 넘길 수있다.
	public static void findClass() throws ClassNotFoundException{
		// java.lang.String2클래스를 찾아서 메모리에 올리는 기능
		Class.forName("java.lang.String2");
	}
	
	
	
}
