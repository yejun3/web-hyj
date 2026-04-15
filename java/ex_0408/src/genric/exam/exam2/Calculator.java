package genric.exam.exam2;

import java.util.List;

public class Calculator {
	
	public static double sum(List<? extends Number>list){
	int total= 0;
	for(Number i : list) {
		total += i.doubleValue();
	              //기본 메서드
	}
	return total;
	}

}
