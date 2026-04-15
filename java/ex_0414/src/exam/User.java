package exam;

public class User {
	private String name;
	private int age;
	private String city;
	
	public User(String name,int age,String city) {
		this.name=name;
		this.age=age;
		this.city=city;
	}
	
	public int getAge() {
		return age;
	}
	public String getCity() {
		return city;
	}
	public String getName() {
		return name;
	}
	/*User클래스
	필드(생성자를 통해서 초기화)
	- String name
	- int age
	- String city

	UserFilter함수형 인터페이스
	추상메서드
	boolean test(User user);

	UserService클래스
	UserFilter getFilter(String type)
	- "adult"를 받으면 나이가 20살 이상인 회원을 반환하는 람다식을 반환
	- "seoul"을 받으면 거지주가 서울인 회원을 반환하는 람다식을 반환
	- "kim"이면 이름이 김으로 시작하는 회원을 반환하는 람다식을 반환

	filterUsers(List list, 람다식)
	- 조건에 맞는 회원들만 출력하기*/
}
