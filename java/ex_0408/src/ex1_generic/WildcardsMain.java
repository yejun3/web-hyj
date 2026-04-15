package ex1_generic;

import java.util.Arrays;
import java.util.List;

public class WildcardsMain {
	public static void main(String[] args) {
		Wildcards wc = new Wildcards();
		
		List<String> list1 = Arrays.asList("A","B","C");
		List<Integer> list2 = Arrays.asList(1,2,3);
		List<Double> list3 = Arrays.asList(1.3,2.2,3.5);
		
		wc.printList(list1);
		wc.printList(list2);
		wc.printNumbers(list2);
		wc.printNumbers(list3);
     // wc.printNumbers(list1) ->실행이 안됨 list1배열의 타입은 String이라서 제한에 걸림
		
	}

}
