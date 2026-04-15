package ex1_set.Hashset;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Set 인터페이스가 제공하는 메서드
//void add (E e) : 데이터를 삽입
//void clear (): 모든 데이터를 삭제
//void remove(object o :선택한 데이터를 삭제
//int.size(): 저장된 데이터의 갯수를 반환
//contains(E e): 셋에 해당 데이터가 저장되어있는지 확인

public class HashsetExample {
	public static void main(String[] args) {
   // Hash클래스는 Set인터페이스에서 가장 많이 사용되는 구현클래스이다.
		Set<String> set = new HashSet<>();
		
		set.add("java");
		set.add("String");
		set.add("React");	
	    set.add("java");// 에러는 안남 똑같은 것을 추가하지않음
		
		System.out.println(set);
	
		
	System.out.println("개수: " + set.size());
	Set<Integer> set2 = new HashSet<>(Arrays.asList(1,2,3,4,4,2,3,1));
	
	System.out.println(set2);
	
	//HashSet에 1~45 난수 6개 담기
	
	Set<Integer> lotto = new HashSet<>();
	
	
	//for(int i=0; i<6; i++) {
	//int random = (int)(Math.random()*45+1);
	//lotto.add(random);
	//}
	//일반 for문으로 쓰면 횟수가 6번으로 정해져 있어서 겹쳤을때 6개를 못 얻음
	// While문을 사용한다.
	   while (lotto.size() < 6) {
	   int random = (int)(Math.random() * 45 + 1);
	   lotto.add(random);
	}
	
	System.out.println(lotto);

	
	// set을 배열로 만들기 
	//  Integer[0] 배열의 크기가 0인데 왜 문제가 없는가?
	//new Integer[0] -> 배열의 방 갯수를 0으로 하면 set이 add로 넣은 개수만큼
	//자동으로 배열의 index가 만들어진다.
	//toArray
	Integer [] arr = lotto.toArray(new Integer[0]);
	
	
	}	
}
