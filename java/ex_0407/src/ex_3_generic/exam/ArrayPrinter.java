package ex_3_generic.exam;

public class ArrayPrinter {
	
	//배열을 외부에서 전달받아 화면에 출력하는 기능을 가진 
	//printArray 제네릭 메서드 작성하기
	
	//Main에서 다음의 배열들을 출력하기
	//String []name = {"김철수","이영희","박민수"}
	//integer[] nums = {10,20,30}

	// 접근제한자 제네릭 반환형 매서드명(){}
	
		//배열 타입은 아직 정해지지 않았으므로 타입은 T
		public <T> void printArray(T[]arr) {
			for(int i =0; i<arr.length; i++) {
				System.out.println(arr[i]);
			}
		}
}
