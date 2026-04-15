package ex2_lambda;

public class Main {
	public static void main(String[] args) {
		//1. 구현 클래스 만들어서 사용하기
		MyfuntionImpl mi = new MyfuntionImpl();
		mi.run();
	
	//2. 익명클래스 만들기
		MyFuntion m = new MyFuntion() {
			@Override
			public void run() {
				System.out.println("익명클래스");
				
			}
		};
		m.run();
	
	//3. 람다식 사용하기
		MyFuntion m2 = () -> {System.out.println("람다식");};
	//반환형 메서드명 모두 없앰 (매개변수) -> {실행문}
		
		
	// 람다식을 사용하는 이유
	// 1. 코드가 짧아진다.
	// 익명 클래스보다 코드를 짧게 작성할 수 있다.
	
	//핵심 로직이 잘보인다.
	//클래스 선언, 	메서드 선언과 같은 껍데기를 줄이고
	//실제로 하고싶은 동작만 보이게 할 수있다.
		
	//3. 컬렉션 처리에 유용하다.
	//정렬,필터링,반복처리같은 작업에서 자주 사용된다.
	
	//4.함수형 프로그램밍 스타일을 일부 사용할 수있다.
		
	
	
	//람다식은 변수에 담을 수 있다.
	//타입이 인터페이스여야함
	
	//매개변수가 1개인 람다식	
	//PrintNumber p2 = num -> System.out.println(num);
	PrintNumber pn = System.out::println;
	pn.print();
	//매개변수가 2개인 람다식
	//매개변수에 전달된 두 개의 숫자를 더하여 반환하는 람다식 작성하기
	//명령이 한 줄이고 return과 중괄호는 같이 생략 할수 있다.
	
	Add add = (a,b) -> a + b;    //람다식을 만듦
	int result = add.sum(10, 7); // 호출해서 값을 전달
	System.out.println(result);
	
	//NumberCheck라는 함수형 인터페이스를 만든다.
	//정수형 매개변수를 1개를 갖고, 반환형이 논리형인 test()추상 메서드를 작성한다.
	//Main에서 
	//1. 짝수인지 판별하는 람다식을 만든다.
	//2. 2. 0보다 큰지 판별하는 람다식을 만든다.
	//숫자를 전달하고 결과 확인
	
	NumberCheck ch1 = check -> check%2==0;
	NumberCheck ch2 = check -> check>0;
	
	int check1=4;
	int check2=5;
	System.out.println(ch1.test(check1));
	System.out.println(ch2.test(check2));
	
	}

	
}
