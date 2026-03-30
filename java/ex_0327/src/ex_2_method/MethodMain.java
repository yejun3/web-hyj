package ex_2_method;

public class MethodMain {
	public static void main(String[] args) {
		
		//1. 객체가 정의되어야한다.
		MethodExample m =new MethodExample();
		//2.객체를 통해 메서드가 호출해야된다.	
		m.printinfo();
	
					
	             
    int result = m.add(10,7);
	System.out.println(result);
	
	double result2 = m.circleArea(4);
	System.out.println(result2);
	
	int result3 = m.countEven(4);
	System.out.println(result3);
	
	
	
	}
  
	
}
