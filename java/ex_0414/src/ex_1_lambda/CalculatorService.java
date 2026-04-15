package ex_1_lambda;

public class CalculatorService {
	
	//람다를 매개변수로 받는 메서드
	//식 자체를 매개변수로 넘길수 있음
	public void execute(Calculator calculator) {
		int result = calculator.calc(10, 20);
		System.out.println("결과: "+ result);
		
		//Calculator c = (a,b) -> a+b; //람다식을 변수 c에 저장
	    //cs.execute(c); //객체를 통해 메서드호출 c의 저장된 람다식을 매개변수 calculator에 넘김
		//cs.execute((a,b) -> a+b); //이것과 같음 
	    
		//메서드 호출해서 값을 넣는 모습과 같아짐
		
		
	}
	
	//람다를 반환하는 메서드
	//매개변수로 "add로 문자열이 넘어오면 두수를 더해서 변환 
	//"sub"문자열이 넘어오면 두 수를 뺴서 반환
	public Calculator getCalculator(String type) {
		if(type.equals("add")){
			return (a,b) -> a+b;
		}else if(type.equals("sub")) {
			return (a,b) -> a-b;
		}else {
			return null;
		}
				
	}
}
