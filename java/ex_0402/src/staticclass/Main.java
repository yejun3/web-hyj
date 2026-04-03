package staticclass;

public class Main {
	public static void main(String[] args) {
		
		//정적 내부클래스의 객체 생성방법 
		Outer.Inner inner = new Outer.Inner();
		
		User.Builder user = new User.Builder().id("hong").password("1234").name("홍").email("@");
		
		
		
		
		
		
		//단점
		//매개변수가 많아서 순서를 헤살리기 쉽다.
		//어떤값이 필수인지 한 눈에 보기 어렵다.
		// 생성자가 너무 많아 오버로딩 될 수있다.
		//User user1 = new User("a","a","a","a");
	
	
	

	
	
	
	}
}
