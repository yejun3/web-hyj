package ex_1_List.ArrayList.exam;

import java.util.ArrayList;
import java.util.List;

public class Arraylength {
	public static void main(String[] args) {
		//문자열 타입 리스트 객체를 만든다
		//리스트 "java","Spring","HTML","CSS"를 저장하기
		//각 문자열의 길이를 계산하여 lengths라는 새로운 리스트를 만들어서 저장
		//lengths 리스트 출력하기
		
		List<String>list= new ArrayList<>();
		List<Integer>list2= new ArrayList<>();
		
		list.add("java");
		list.add("Spring");
		list.add("HTML");
		list.add("CSS");
	
   // 문자열 길이를 구하는 것에서 막힘	
    for(int i=0; i<list.size(); i++) {
    	String s = list.get(i); //list 요소에서 값을 담을 문자열 변수만들고 초기화
    	list2.add(s.length()); //list2에 문자열의 길이를 담기 
    }
	
	
	
	System.out.println(list2);
	
	
	//문자열 형태의 리스트 생성하기
	//"김철수" "이영희" "김철수","박민수","김철수"저장하기
	//리스트에서 "김철수" 몇 번 나왔는지 계산 
	List<String> listN = new ArrayList<>();
	listN.add("김철수");
	listN.add("이영희"); 
	listN.add("김철수"); 
	listN.add("박민수"); 
	listN.add("김철수"); 
	
	int count = 0;
	for(int i =0; i<listN.size(); i++) {
		if(listN.get(i).equals("김철수")) {
			count+=1;
		}
	}
	System.out.println("횟수: " +count);
	
	
	//scores라는 이름의 정수타입 리스트생성
	//88,72,95,60,81을 저장
	//최고점수와 최소점수를 찾아서 차이를 입력
	List<Integer> scores = new ArrayList<>();
	scores.add(88);
	scores.add(72);
	scores.add(95);
	scores.add(60);
	scores.add(81);
	
	int max = scores.get(0);
	int min = scores.get(0); //max와 min
	
	for(int i =0; i<scores.size(); i++) {
		int score = scores.get(i);
		if(max < score ) {
			max=score;
		}
		if(min > score) {
	     min = score;
		}
	}
	int dis = max-min;
	System.out.println(dis);
	
	
	
	
	
	}

}
