package ex_3_generic.exam;

public class Main {
	public static void main(String[] args) {
		ArrayPrinter a = new ArrayPrinter();
		String [] name = {"김철수","이영희","박민수"};
		Integer[] nums = {10,20,30};
		Object [] kaos = {"자바",325,14.0};
		
		//호출 시점에 String[], Integer[] 등 타입이 자동으로 추론됨.
		//코드 재사용성이 높아지고 형변환이 필요 없음.
		//타입 추론
	    //제네릭 메서드를 호출할 때 전달한 값으로 타입을 자동 판단한다.
		
		a.printArray(name);
		a.printArray(nums);
		a.printArray(kaos);

	}
}