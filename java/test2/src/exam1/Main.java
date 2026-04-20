package exam1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		List<Member> members = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
	
	for(int i=0; i<3; i++) {
		System.out.println("아이디: ");
		String id = sc.next();
		System.out.println("이름 :");
		String name = sc.next();
		System.out.println("나이: ");
		int age =  sc.nextInt();
		members.add(new Member(id,name,age));
	}
	
	for(Member m : members) {
		m.printinfo();
	}
	int count =0;
	for(Member m : members) {
		if(m.getAge()>=20) {
			count++;
		}
	}
	System.out.println("20세 이상 회원수 : " +count);
	sc.close();
	}

}
