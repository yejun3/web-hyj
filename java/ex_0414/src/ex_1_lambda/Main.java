package ex_1_lambda;

import exam.TextService;

public class Main {
	public static void main(String[] args) {
		CalculatorService cs = new CalculatorService();
		
		//Calculator calculator = (a,b) -> a+b
		//int result = calculator.calr(1,2)
		//System.out.println(result);
		
		Calculator c = (a,b) -> a+b; //람다식을 변수에 저장
		cs.execute(c);               //객체를 통해 메서드호출
		cs.execute((a,b) -> a+b);    //직접넣어도 됨
	//c가 CalculatorService에 매개변수 자리로 이동
	
	//람다식을 반환받아서 서용
		Calculator add = cs.getCalculator("add");
		Calculator sub = cs.getCalculator("sub");
	
	System.out.println(add.calc(2, 4));
	System.out.println(sub.calc(8, 6));
	}

}
