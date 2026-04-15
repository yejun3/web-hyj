package ex_1_List.ArrayList.exam;

import java.util.ArrayList;
import java.util.List;

public class ArrayExam {
	public static void main(String[] args) {
		//Integer 타입의 리스트 만들기
		List<Integer> list = new ArrayList<>();
		//List 만들때 import해줄 것
		// 리스트에 (1~30난수 10개 넣기)
		
		for(int i =0; i<10; i++){
	    int a = (int)(Math.random()*30)+1;	
		list.add(a);	
		}
		//반복문 밖에다 난수를 설정하는 코드를 써서 난수를 1번만 뽑고
		//똑같은 수 10개를 집어넣는 실수를 함
	System.out.println(list);
 
	int sum = 0;
 for(int j= 0; j<list.size(); j++) {
	if(list.get(j)%2!=0) {
	 sum+=list.get(j);
	}
}
	System.out.println("총합: " + sum);
	
	
	}
}
