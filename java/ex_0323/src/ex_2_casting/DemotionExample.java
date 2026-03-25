package ex_2_casting;

public class DemotionExample {
	public static void main(String[] args) {
		
		//int> byte
		int var1 = 10;
		byte var2 = (byte)var1;
		System.out.println(var2);
		
		// long> int
		long var3 =300;
		int var4 =(int)var3;
		System.out.println(var4);
		
		//int > char
		int var5 = 65;
		char var6 = (char)var5;
		System.out.println(var6);
		
		//위의 경우에서는 값의 손실은 없다.
		
	   double var7 = 3.141592;
	   int var8 = (int)var7;
	   System.out.println(var8);
	   // 실수를 정수로 변환하면 소수점 아래의 숫자들이 소실됨
	   // 내가 생각한 것과 다른 결과 나올 수 있으므로 주의해야 함
	   
	   byte result = 10 + 20;
	   System.out.println("result:" + result);
	   byte v1 = 10;
	   byte v2 = 20;
	   
	   // 10+20 계산 됨 
	   // java에서는 byte, short, char끼리의 연산은
	   // 자동으로 int로 변환이 된다.
	   
	   byte v3 = (byte)(v1 + v2);
	  s
	   // 변수끼리의 연산은 실행시점에 연산이 된다.
	   // 컴파일러는 확실한 값이 고정된 경우에만 미리 계산한다.
	   // 강제형변환을 히던지 int형으로 바꿔줌
	   
	   
	}
	

}
