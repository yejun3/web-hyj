package exam;

public class Converter {
	/*문자열 정수 변환 프로그램
	Converter클래스
	toInt(String str)메서드를 만든다.
	ㄴ 문자열을 정수로 만들어서 반환한다.
	메서드 안에서 예외를 처리하지 않고 떠넘긴다.
	Main클래스에서 문자열을 입력받아 Converter 객체를 이용해 호출한다.
	숫자로 변환할 수 없으면 "숫자로 변환할 수 없습니다." 출력하기
	*/	
	//Integer.parseInt(data)
	//문자열을 정수로 바꿈
	public int toInt(String str) throws Exception{
		return Integer.parseInt(str);	
}	



}
