package ex_2_method;

public class MethodExample {
	
	//메서드의 구조
	//접근제한자 반환형 메서드명(매개변수){
	// 실행하고자 하는 명령
	// return 반환값;
	// }
	
	//반환할값이 없으면 반환형은 void
	//외부에서 받을 값이 없으면 매개변수는 생략 가능하다.
	
	//"매서드가 호출되었습니다." 라고 출력되는 printinfo 메서드 작성하기
	
	 public void printinfo() {
	System.out.println("매서드가 호출되었습니다.");
	 }

	// 두 수를 더하여 작성하는 add 작성하기
	public int add(int a, int b) { 
		int x = a;
		int y = b;
		int z =	x+y;	
		return z;	
		//return a+b;도 가능
	}

     // 원의 넓이를 구하는 circleArea메서드 작성하기
	
	   // 1. 매서드를 정의한다.
	   //외부에서 받아야 할 값이 있으면 매개변수를 설정
	// -코드블럭 ({} 안 공간을 의미) 기능을 정의
	//-연산 결과를 보내줘야 하면 return을 정의
		public double circleArea(int a) { 
			return a * a * 3.14;
		}
		
        // 원의 둘레를 구하는 cicleRound매서드 정의 
		// 반지름은 외부에서 전달
		// 매서드 내부에서 원의 둘레를 구하고 출력한 다음 종료
		
		public void circleRound(int r) {
			double round = 2*r*3.14;
			System.out.println(round);
		}
// 반환할 값이 없으므로 void를 씀
		
		
 // 정수 배열을 매개변수로 받아서 짝수의 갯수를 반환하는 countEven 메서드 작성하기
		
		public int countEven(int a) {
			int[] arr = new int[a];
			int count=0;		
			for(int i=1; i<arr.length; i++){
						if(i%2==0) { count++; }
				}
		return count;
		
		}
	//매서드를 만드는 이유
    // 자주 사용하는 기능을 재사용하기 위함
		
   // 특정문자세기
   // 문자열과 문자 하나를 매개변수로 받아서 
   // 문자열에서 해당 문자가 몇 번 반환하는지 countChar 매서드작성하기
		public int countChar(String s, char ch) {
			int count =0;
			for(String str : s.split("")){
				if(str.charAt(0) == ch) {
					count++;
				}
			}
			
			return count;
		}
					










}		
			
			
		






		
	

	 
	 
