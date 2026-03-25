package ex5_operator;

public class CheckExample {
	public static void main(String[] args) {
		int x=5;
		double y = 0.0;
		double z = x / y;
		
		// infinite : 무한대
		System.out.println(Double.isInfinite(z));
		z = x % y;
	
		
		// NaN : Not a Number
		
		System.out.println(Double.isFinite(z));
				
		
	}

}
