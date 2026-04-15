package ex2_Iterator;
//반복자 (Iterator)
//컬렉션  인에 들어있는 여러 데이터를 하나씩 꺼내서 확인하는 도구
//-컬렉션의 처음부터 끝까지 이동한다.
//-안에 들어있는 요소를 하나씩 꺼낸다.
//- 필요하면 현재 요소를 삭제할 수 있다.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {
	public static void main(String[] args) {
		List<Integer>list = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
	
		//Iterator 객체는 컬렉션 객체로부터 생성
		Iterator<Integer> iter = list.iterator();
		
    //Iterator의 주요 메서드
	//	next(), hasNext(), remove()
	
	// next() : 요소를 하나 반환하고 다음 요소로 이동
	//다음 요소를 하나 반환한다,다음위치로 이동도 한다.
    
	// hasNext()
    // 다음 요소가 있으면 true, 없으면 false를 반환한다.
		
	// remove()
	//현재 반복자가 마지막으로 꺼낸 요소를 삭제한다.
		
	while(iter.hasNext()) {
		int val = iter.next();
		System.out.println(val);
	}
	
	HashSet<String> set = new HashSet<String>();
	set.add("사과");
	set.add("포도");
	set.add("바나나");
	
	Iterator<String> iter2 = set.iterator();
	
	// 반복자의 next()메서드를 통해 하나씩 꺼낼 수 있다.
	while(iter2.hasNext()){
		System.out.println(iter2.next());	
	}
	//향상된 for문 내부에는 삭제는 불가능하다.
	//반복중에 remove()를 이용하여 삭제를 하면
	//Iterator가 관리하는 상태와 Set의 상태가 달라지게 된다.
	for(String f : set) {
		System.out.println(f);
	}
	//향상된 for문은 내부적으로 반복자를 사용하고 있다.
	Iterator<String> it = set.iterator();
	
	while(it.hasNext()){
		String f = it.next();
		if(f.equals("바나나")){
		it.remove();//안전하게 삭제	
		}
	}
	
	System.out.println(set);
	
	}
	}
	


