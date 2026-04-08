package ex2.annotation;


//자바컴파일러가 띄우는 경고 메세지를 일부러 무시하도록 지시하는 어노테이션
@SuppressWarnings({"unchecked","unused","deprecation"})

//경고를 여러개 사용하고 싶으면 초기화 리스트 방식으로 사용

//경고의 종류 
//unchecked : 타입검사가 완전하지 않을 때 발새하는 경고를 숨긴다.
//deprecation : 사용 권장되지 않는 기능을 사용할 떄 무시
//unused: 사용하지 않는 변수, 매개 변수, 필드에 대한 경고를 숨긴다.
//all : 모두 경고무시
public class SupperssExample {
	public static void main(String[] args) {
		int num = 100;
		DeprecatedExample de = new DeprecatedExample();
		de.oldMethod();
	}
}






