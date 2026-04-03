package ex_1_exception;

//NullPointerException : 참조변수가 null인 상태에서 필드나 메서드에 접근할 경우 
//발생하는 예외

public class ExceptionHandlingExample1 {
	//문자열 데이터를 전달받아서 문자열의 길이가 얼만지 출력하는 메서드 작성하기
	
 String str;
 public ExceptionHandlingExample1(String str) {
	 this.str=str;
 }
	
	public static void printLength(String str) {
		try {
			//예외가 발생할 수도 있고 아닐수도 있음
		System.out.println("문자열길이: " + str.length());
		// 예외가 발생하면 발생한 예외클래스의 객체가 만들어지게 된다.
		//catch의 매개변수로 들어온다.
		} catch(NullPointerException e) {
			//catch는 예외가 발생할 시 실행되는 코드
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			//(e.getMessage())예외가 발생한 이유만 반환한다.
			//(e.toString()) 예외의 종류도 반환
		e.printStackTrace(); // 예외가 어디서 발생했는지 추적한 내용까지 출력한다.
		System.out.println("에러가 발생했습니다.");
		}finally {//예외가 있든 없든 무조건 실행
			System.out.println("무조건 실행됨");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("[프로그램 시작]");
		printLength("This is java");
		printLength(null);
		System.out.println("[프로그램 종료]");
	}
}
