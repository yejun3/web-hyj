package dto;

// **DTO (Data Transfer Object)**
// 쿼리 결과(DB 데이터)를 자바 객체로 담기 위한 클래스
public class MemberDTO {

	// 필드 (DB 컬럼과 1:1 매핑)
	private int id;
	private String name;
	private String email;
	private int age;

	// 생성자
	public MemberDTO(int id) {
		this.id = id;
	}
	
	// 생성자
	public MemberDTO(int age,int id) {
		this.id = id;
		this.age = age;
	}
	
	// 생성자
	public MemberDTO(String name, String email, int age) {
		this.name = name;
		this.email = email;
		this.age = age;
	}
	// 모든 필드를 매개변수로 받는 생성자
	public MemberDTO(int id, String name, String email, int age) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
	}
	
	// setter 만들기
	public void setAge(int age) {
		this.age = age;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	// getter (데이터 꺼낼 때 사용)
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public int getAge() {
		return age;
	}

	// toString (출력 편하게 보기용)
	@Override
	public String toString() {
		return "MemberDTO [id=" + id +
				", name=" + name +
				", email=" + email +
				", age=" + age + "]";
	}
}