package ex3_String;

//범위를 가지고 사용하는 매서드 특징
//대부분 끝값은 포함되지 않는다.
public class StringBuilderExample {
	public static void main(String[] args) {
		//toString()을 제외하는 다른 메서드는 StringBuilder객체를 반환한다.
		//그렇기 때문에 연이어서 다른 메서들를 호출할 수 있는 메서드 체이닝
		// 패턴을 사용 할 수 있다.
		//toString()만은 String 객체를 반환 -> 체이닝 끝나고 문자열 변환
		//나머지 메서드는 StringBuilder를 반환 → 이어서 다른 메서드를 호출 가능
		String data = new StringBuilder().append("DEF")
				.insert(0, "ABC")
				.delete(3,4)
				.toString();
		System.out.println(data);
	}

	//자주 변경되는 문자열이 있을 떄 String에 넣지말고 Stringbuilder에 넣어라
	
	
}
