package ex_1_List.ArrayList;
import java.util.ArrayList;
import java.util.List;
public class ArrayListExample {
	public static void main(String[] args) {
	//ArrayList
	//List인터페이스를 구현한 대표적인 클래스
	//내부구조 : 배열을 기반으로 동작
	//장점: 조회속도가 빠르다.(index로 접근하기 떄문에)
	//단점: 중간 삽입/삭제 느리다.(	데이터의 이동이 발생한다.)
	
	//빅오(Big-O)표기법 데이터입력량과 연산횟수에 따른 처리속도를 표기함
	
	//언제쓰면 좋을까?
    //삽입/삭제는 많지 않은데 조회가 많을때
		
	//java.util패키지에 들어있다.	
	//구현클래스의 객체는 해당 인터페이스의 타입변수에 담을 수있다.
	
	List<String> list = new ArrayList<String>();
	
	//리스트에 데이터 추가하기
	list.add("A");
	list.add("B");
	if(list.add("C")) {
		System.out.println("데이터가 정상적으로 추가되었습니다.");
	}else {System.out.println("데이터가 추가되지 않았습니다.");
	
	}
	// 내가 원하는 위치에 데이터 넣기
	list.add(1,"데이터");
	
	//데이터 값 바꾸기 
	list.set(1,"D");
	
	//리스트의 출력
	System.out.println(list);
	
	//리스트의 들에있는 데이터 하나만 꺼내기
	String s = list.get(0);
			System.out.println(s);
	
	//연속되지 않은 인덱스에 값을 넣으려고 하면 
	//ArraysIndexOutOfBoundsException발생
	//list.add(7,"F");
			System.out.println(list);
	
	
	//정수타입 담을 수 있는 list객체 만들기
	List<Integer>list2 = new ArrayList<>();
	
	//2부터 짝수 데이터 10개 추가하기
	
	for(int i= 1; i<= 10; i++) {
		if(i%2==0) {
			list2.add(i);
		}
	}
	
	System.out.println(list2);
	
	// 3번 인데스의 내용삭제
	int delNum = list2.remove(3);
	System.out.println("삭제 후 " + list2);
	System.out.println("삭제된 숫자" + delNum);
	
	list2.add(10);
	list2.add(10);
	System.out.println(list2);
	//데이터를 직접지우고 싶음
	//숫자타입의 데이터는 객체화 후 삭제
	boolean result = list2.remove(Integer.valueOf(10)); //값을 지정해서 삭제
 if(result) {
	 System.out.println("삭제가 잘 되었습니다.");
 }
 System.out.println(list2);
	//list2에들에있는 모든 10을 삭제하기

 //list는 배열이 아니므로 .length가 아니라 .size()를 사용해야한다.
	for(int j=0; j<list2.size(); j++) {
		list2.remove(Integer.valueOf(10));
	}

	
	
	System.out.println(list2);
	}
}
