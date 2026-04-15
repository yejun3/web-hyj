package ex2_Iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class exam {
	public static void main(String[] args) {
		// 사용자로부터 여러개의 문자열을 입력받아 List에 저장
		//이 후 중복을 제거하고 정령하여 출력하는 프로그램  작성하기 
		//입력을 exit로 종료
		//list의 정렬 Collections.sort(리스트);정렬됨
	List<String> list = new ArrayList<>(Arrays.asList());
		
	Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("문자열 입력(exit입력시 종료)");
			String input = sc.next();
		if(input.equalsIgnoreCase("exit")) {
			break;
		}
		
		list.add(input);
		
	   }
		
		
	 Set<String> set = new HashSet<String>(list);
	 List<String>result = new ArrayList<String>(set);

	//정렬
	Collections.sort(result);
	 System.out.println("중복제거 후 정렬 결과" + result);
	
	//학생 이름을  입력받아 List에 저장
	 //이미 존재하는 이름이면 추가하지 않고 "이미 존재하는 이름입니다" 메세지를 출력한다.
	
	 List<String> namelist = new ArrayList<>();
	 
	 while(true) {
		 System.out.println("이름: ");
		 String name = sc.next();
		 if(name.equalsIgnoreCase(name)) {
				break;
			}  
		 if(namelist.contains(name)) {
			 System.out.println("이미 존재하는 이름입니다.");
		 }else {
			 namelist.add(name);
		 }
	
	 }
	
	
	
	
	
	
	
	
	
	}

}
