package ex_1_List.ArrayList.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	
    // 3명의 아이디와 비밀번호를 입력하여 list에 저장
	// 일일이 다 쓰기 보다 반복문 사용
	
	Scanner sc = new Scanner(System.in);
	List<UserInfo> list = new ArrayList<>();
	

    // 아이디가 중복되면 다시 입력 받기
	//outer대소문자를 오타내서 계속 오류떴었음 잘 적었는지 확인하자
	
	outer:for(int i=0; i<3; i++) {
		UserInfo user = new UserInfo();
		System.out.println("아이디 입력: ");
	    user.setId(sc.next());
	    //아이디에 입력받고 list에 겹치는 게 있는지 확인
	  for(int j=0; j<i;j ++) {
		  if(user.getId().equals(list.get(j).getId())){
	    System.out.println("아이디가 중복됩니다.");
		i--;
		continue outer;
	  }
	}
		 
	System.out.println("비밀번호입력: ");
	    user.setNumber(sc.nextInt());
	    	list.add(user);
	   
	    for(UserInfo u : list) {
	    	System.out.println(u.getId());
	    	System.out.println(u.getNumber());
	        System.out.println("--------------");
	    }   
	}
	}
  }

