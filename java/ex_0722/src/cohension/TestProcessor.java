package cohension;

//순차적 응집도
// 앞 작업의 결과물(반환값)이 바로 다음 작업의 재료(입력값)가 되는 관계
// - 작업들이 강하게 결합된다.
// - 내부의 특정 단계만 독립적으로 재사용되거나 순서가 바꾸기가 어렵다.
// - 중간 과정에서 오류가 발생하면 이후 단계에서 전체가 영향을 받아 멈춤
public class TestProcessor {
	
	public void proocessText(String text) {
		//1. 공백 제거
		String trimmed = removeSpace(text);
		
		//1에서 나온 결과를 대문자로 바꾼다.
		String upper = covertToupper(trimmed);
	}

	
	private String removeSpace(String text) {
		return text.trim(); //text의 공백을 제거하고 반환 
	} 
	
	private String covertToupper(String text) {
		return text.toUpperCase();
	}
}
