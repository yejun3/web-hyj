package ex5;

public class NullExample {
	public static void main(String[] args) {
		//nullponterException
		//객체가 없는 상황에서 객체를 사용하려고 해서 생기는 오류
		String str = null;
		System.out.println(str.length());
	}

}
