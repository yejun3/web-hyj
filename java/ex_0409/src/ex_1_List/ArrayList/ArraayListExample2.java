package ex_1_List.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ArraayListExample2 {
	public static void main(String[] args) {
//		List<String> names = new ArrayList<String>();
//		List<Integer> age = new ArrayList<Integer>();
//	names.add("홍길동");
//	age.add(30);
	//- 기존방식
	
	
	List<Member> members = new ArrayList<>();
	//ArrayList에 들어가는 것은 Member 객체
	
	Member m1 = new Member();
	m1.setName("홍길동");
	m1.setAge(30);
	
	members.add(m1);
	members.add(new Member());//"박민수",40
	
	System.out.println(members.get(0).getName());
	System.out.println(members.get(0).getAge());
	
	Member m2 = new Member();
	members.add(m2);

	members.get(1).setName("박민수");
	members.get(1).setAge(40);
	System.out.println(members.get(1).getName());
	System.out.println(members.get(1).getAge());
	
	
	Member m3 = new Member();
	members.add(m3);
	members.get(2).setName("김철수");
	members.get(2).setAge(25);
	System.out.println(members.get(2).getName());
	System.out.println(members.get(2).getAge());
	
	
	}

}
