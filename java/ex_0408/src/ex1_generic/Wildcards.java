package ex1_generic;
//와일드카드
//제네릭 타입에서 "정확한 타입은 모르겠지만 , 어떤 범위 안에 있는 타입이다."
//List<String> : 정확히 String을 담을 수있는 리스트
//List<Integer> : 정확히 Integer을 담을 수있는 리스트
//와일드카드의 기본문법
//<?> :타입을 모름,아무타입이나 가능함
//<? extends T> : T 또는 T의 자식 타입만 가능함(상한제한)
//<? super T> : T 또는 부모타입만 가능함(하한 제한)

import java.util.List;
//<T extends Number> -> 타입한정 -. 타입을 정의하는것 
//와일드 카드가 써 있는 것들은 대부분 일기 전용이다.
//와일드카드는 매개변수에서 사용되는 경우가 많다.
//이미 만들어진 객체를 받을 때 사용한다.
public class Wildcards {
	//?에 어떤 타입이 들어올지 알 수 없기 때문이다.
	public void printList(List<?>list) {
		for(Object obj : list) {
			System.out.println(obj);
		}
	}
//상한 제한 와일드카드
	public void printNumbers(List<? extends Number>list) {
		for(Object obj : list) {
			System.out.println(obj);
		}
	}


}

