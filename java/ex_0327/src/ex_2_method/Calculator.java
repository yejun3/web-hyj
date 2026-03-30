package ex_2_method;

public class Calculator {
	//계산기 기능이 있는 메서드
	//숫자 2개, 문자열타입의 연산자
	public int getResult(int a, int b, String op) {
		if(op.equals("+")) {
			return a + b;
		} else if (op.equals("-")) {
			return a - b;
		} else if (op.equals("*")) {
			return a * b;
		} else if (op.equals("/")) {
			return a / b;
		} else {
			return -1;
		}
	}

}
