package staticclass.exam;
/*
정적내부클래스로 계산 결과 객체 만들기
Calculator클래스
메서드
add(int a, int b) : 두 수를 더한 뒤 반환하세요
Result 정적 내부 클래스
필드
- value
생성자를 만들어 계산 결과를 저장하세요
메서드
show() : "계산결과 : X"형식으로 출력하세요
main에서 add()를 호출하고 반환된 Result객체의 show()를 호출하세요
*/

public class Calculator {
 
 public static class Result{
	 int value;
	 
	 public Result (int value) {
			this.value= value;
		}
	 
	 Result add(int a , int b) {
			return new Result(a+b);
		}
 }


}
