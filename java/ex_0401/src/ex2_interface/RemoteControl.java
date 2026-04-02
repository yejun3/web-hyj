package ex2_interface;

public interface RemoteControl {

	
	int MAX_VOLUME =10;
	int MIN_VOLUME =0;// 생략해도 상수 취급이다.
	
	// 추상 메서드
	public void turnOn();
	void turnOff();
	public void setVolume(int volume);
	
	//디폴트 메서드
	//디폴트 메서드에서는 실행부가 있다.
	//상수 필드를 읽거나 추상 메서드를 호출하는 코드를 작성할 수있다.
	//구현 클래스는 디폴트 메소드를 오버라이딩하여 자신에 맞게 수정할 수있다.
	//default 키워드를 생략할 수 있다.
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리합니다.");
		}else {
			System.out.println("무음 해제합니다.");
		}
		
	}
	
	//정적 메서드
	// static 메서드는 구현 객체가 없어도 인처페이스 만으로 호출 할수있다.
	 static void ChangeBattery() {
       System.out.println("리모콘 건전지를 교체합니다.");
	     }
	 
	 //private 메서드
	 //인터페이스 외부에도 접근 할 수 없는
	 
	 
	 
	 
	 
}
