package ex5_singleton;

public class Singleton {
	//클래스 내부에서 객체를 생성함
	private static Singleton singleton = new Singleton();
	
	private Singleton() {
		
	}
	public static Singleton getInstance(){
		return singleton;
	}
}
