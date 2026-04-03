package ex_1_exception;

public class CatchExample {
	public static void main(String[] args) {
		
			String [] array= {"100","1oo"};
			
			for(int i = 0; i <= array.length; i++) {
				try {
					int value = Integer.parseInt(array[i]);
 //Integer.parseInt(array[i]); : 문자열(String)을 정수(int)로 변환하는 코드
		}catch(NumberFormatException e) {
			System.out.println("숫자로 변환할 수 없음 :" + e.getMessage());	
		}catch(ArrayIndexOutOfBoundsException | NullPointerException e) {
			System.out.println("배열 인덱스 초과됨: " + e.getMessage());
// i = 2 까지 실행되야 하는데 배열의 index는 0,1까지 밖에 없음 
		}catch(Exception e) {
			//예외가 발생하면 catch블록은 위에서부터 차례대로 검사 대상이 되는데
			//하위 예외도 상위 클래스타입 변수에 대입될 수 있기 때문에 
			//마지막에 써야한다.
			System.out.println("실행에 문제가 있음");
		}
	}
	}
}
