package exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginExample {
	public static void main(String[] args) {
	Map<String,String> users = new HashMap<>();
	users.put("admin", "1234");
    users.put("user1", "abcd");
    users.put("guest", "1111");
    
    Scanner sc = new Scanner(System.in);
    System.out.println("아이디: ");
	String id = sc.next();
	System.out.println("비밀번호: ");
	String password = sc.next();
    
	if(users.containsKey(id) && users.containsValue(password)) {
		System.out.println("로그인 되었습니다.");
    }else if(!users.containsKey(id)) {
    	System.out.println("아이디가 존재하지 않습니다.");
    }else if(users.containsValue(password)) {
    	System.out.println("비밀번호 오류입니다..");
    }else {
    	System.out.println("로그인 실패");
    }

	}
}
	//아이디와 비밀번호를 저장한다.
    //둘 다 String
    //아이디와 비밀번호를 입력해서 로그인을 시도할 때
    //아이디가 존재하지 않습니다.
    //비밀번호 오류입니다.
    //로그인 성공
    //users.put("admin", "1234");
      //users.put("user1", "abcd");
      //users.put("guest", "1111");

 

