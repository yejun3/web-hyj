package ex4_constructor;

public class Person {
	
	String name;
	int age;
	// 생성자에는 반환형이 안들어감
	
	//생성자(정의)
	//매개변수와 클래스의 멤버변수와 이름이 같다면 
	//매개변수의 사용 우선순위가 높다.
	//생성자(or매서드)를 호출한 객체의 필드임을 명시하기 위해 this키워드 사용
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void introduce() {
		System.out.println("안녕하세요 저는 " + age + "살" + name + "입니다."  );	
	}
	//person 클래스를 만든다.
		//필드
		//문자열 타입의 name, 정수타입의, age 
		//매서드
		// "안녕하세요 저는 xx살 xx입니다."라고 출력하는 introduce 매서드
		//PersonMain에 객체를 생성한다.
		//각 객체의 필드는 생성자를 통해 초기화한다.
	
}


