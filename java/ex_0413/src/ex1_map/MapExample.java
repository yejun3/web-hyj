package ex1_map;
//Map은 키(key)와 값(value)을 한 쌍으로 저장하는 자료구조
//키(key): 값(value)를 찾기 위한 이름표 역할

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//키는 중복될 수없다.
//값은 중복될 수 있다.

//index가 없고 key를 통해 데이터에 접근한다.

public class MapExample {
	public static void main(String[] args) {
		//Map은 Key와 Value의 제네릭 타입을 각각 설정해야 한다.
		Map<String, Integer> map = new HashMap<String,Integer>();
	
		//map에 데이터를 저장하는 방법
		//put(K k V v);
		
		map.put("사과",1000);
		map.put("바나나",2000);
		map.put("포도",3000);
		
		//내가 넣은 데이터 순서대로 출력을 보장하지는 않는다.
		System.out.println(map);
		
		//저장한 데이터를 꺼내는 방법
		//get(Key)
		map.get("사과");
		int price = map.get("사과");     
		System.out.println("사과의 가격: " + price);
	
		//없는 key를 조회하려고 하면 null값이 나온다.
		System.out.println(map.get("딸기"));
	
		//Key가 중복값인 Value를 덮어쓴다.
		map.put("사과",1500);
	
		System.out.println("사과의 가격: " + map.get("사과"));
	
		//데이터 삭제하기
		//remove(key)
		//삭제하고 난 후 value값을 반환한다.
		map.remove("사과");
		System.out.println("삭제한값: " + map.remove("사과") );
		System.out.println(map);
		
		//key의 존재여부 확인하기
		//containskey(key): ()안에 값을 가지고 있는지 t/f로 반환
		
		if(map.containsKey("포도")) {
			System.out.println("포도가 존재합니다.");
		}
		
		//value의 존재여부 확인
		//containsValue(value)
		
		if(map.containsValue(2000)) {
			System.out.println("2000짜리 바나나가 존재합니다.");
		}
	
		//map에 들어있는 데이터의 갯수 확인
		//size();
		System.out.println("map의 크기: "+ map.size());
	
		//컬렉션이 비어있는지 확인
		//isEmpty() :문자열의 길이가 0이면(비어있으면) true, 그렇지 않으면 false를 반환합니다
		System.out.println("map에 데이터가 들어있는지 확인: " + map.isEmpty());
	
		//map의 들어있는 모든 key를 Set으로 반환
		//keySet()
		Set<String> set = map.keySet();
		for(String s : set) {
			System.out.println(s);
		}
	
		//key와 value 구분해서 출력
		//key와 value 쌍 전체를 Set<Entry<K,V>>형태로 반환
		
		//key가 존재하면 value를 반환하고 , 없으면 기본값 (defaultvalue)을 반환하는 메서드
		//getOrDefault(object key, defaultValue);
		//get() getOrDefault key가 없으면 null을 반환
		
		//get() 했을 떄 key다 없으면 null을 반환
		System.out.println();
	
	
	
	
	}

}
