package ex_1_exception.throwsexample;

public class ThrowsExample2 {
	//main 메서드에서도 throws 키워드를 사용해서 예외를 떠넘길 수 있다
	//결국JVM이 최종적으로 예외 처리를 하게된다.
	//JVM 예외의 내용을 콘솔에 출력하는 것으로 예외 처리를 한다.
	
	
	public static void main(String[] args)throws Exception {
			findClass();
		} 

	// 나열해야 하는 예외클래스가 많은 경우 throwException 도는 throwable로
	//모든 예외를 간단히 넘길 수있다.
	public static void findClass() throws ClassNotFoundException{
		// java.lang.String2클래스를 찾아서 메모리에 올리는 기능
		Class.forName("java.lang.String2");
	}
	
	
	

}
