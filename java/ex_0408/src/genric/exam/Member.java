package genric.exam;

public class Member {
	
	private String name;
	private int age;
	
	public Member(String name, int age) {
		this.name=name;
		this.age=age;
	}

	//외부에서 안에 데이터를 꺼낼 쓸 수있게 getter를 작성해준다.
	public String getName() {
	return name;
	}

	public int getAge() {
	return age;
	}
}
