package ex2.annotation;

public class Parent {
	public void method() {};
}

//public 클래스는 반드시 파일 이름과 동일해야 합니다.
//파일 이름이 Parent.java라면 public class Child는 오류가 납니다.
// public class Child라고 써서 오류남
class Child extends Parent{
	@Override//부모클래스의 메서드를 재정의한다.
	public void method() {
		// TODO Auto-generated method stub
		super.method();
}
}	
	


