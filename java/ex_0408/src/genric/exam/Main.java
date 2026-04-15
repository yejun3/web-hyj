package genric.exam;

public class Main {
	public static void main(String[] args) {
		//출력 실행에는 main 메서드를 작성
		GenericBox<String> a = new GenericBox<>();
		a.setter("사과");
		System.out.println(a.getter());
		GenericBox<Integer> b = new GenericBox<>();
		b.setter(100);	
		System.out.println(b.getter());
	
	
	
	
	MemberResponse<Member> m = 
	new MemberResponse<>(true,"회원조회성공",new Member("홍길동",27));
	
	//boolean은 true 아니면 false
	// new MemberResponse(new Member()) 
	// Member의 객체 데이터를 MemberResponse통해 간접사용
	System.out.println("성공여부:" + m.isSuccess());
	System.out.println("메세지: "+ m.getMessage());
	System.out.println(m.getData().getName());
	System.out.println(m.getData().getAge());
	}
}
