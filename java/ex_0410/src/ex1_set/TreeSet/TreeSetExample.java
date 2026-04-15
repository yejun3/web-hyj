package ex1_set.TreeSet;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
	public static void main(String[] args) {
		//TreeSet
		//데이터를 자동으로 정렬하면서 저장하는 Set
		
		//1.중복이 허용되지 않는다.
		//Set이 TreeSet보다 상위클래스
		TreeSet<Integer> scores = new TreeSet<Integer>();
		scores.add(50);
		scores.add(10);
		scores.add(30);
		scores.add(20);
     System.out.println(scores);
	
	//TreeSet은 정렬되어 있기 떄문에 특정 범위의 데이터 검색이 편하다
     System.out.println(scores.first());// TreeSet에서 가장 작은 값
     System.out.println(scores.last());//TreeSet에서 가장 큰 값
     
     // scores.first()를 쓰려면 TreeSet 타입인 객체를 쓰던가
     // Set 타입일 때는 TreeSet 타입으로 변환해서 써야한다.
	//first()는 TreeSet클래스에만 정의된 메서드
    
     //lower
     //x보다 작은 값 중 가장 가까운 값
     System.out.println(scores.lower(30));
     
     //higher
     //x보다 큰 값 중 가장 가까운 값
     System.out.println(scores.higher(30));
     
     //중위 순회
    // 왼쪽 끝 -> 부모 ->오른쪽 순으로 
    //가지를 처리하면서 올라감
    
     
	}	
}