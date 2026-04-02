package ex2_interface;

public class Main {
	public static void main(String[] args) {
		//인터페이스도 하나의 타입이기 때문에 변수의 타입으로 사용될 수 있다.
	
	RemoteControl rc;
	
	rc= new Television();
	rc.turnOn();
	
	Television tv = new Television();
	// rc변수에 Audio 객체를 교체할 수있다.
	rc= new Audio();
	rc.turnOn();
	
	//인터페이스 객체를 생성할 수도 없고 
	//상수는 그냥 호출해서 쓸 수있다.
	
	//구현객체와 관련없는 인터페이스 소속 멤버이므로 인터페이스로 접근해서 쓸 수ㅜ있다.
	System.out.println("리모콘 최대 볼륨 : " + RemoteControl.MAX_VOLUME);
	System.out.println("리모콘 최소 볼륨 : " + RemoteControl.MIN_VOLUME);
	
	
	
	rc.setVolume(5);
	rc.setMute(true);
	rc.setMute(false);
	
	RemoteControl.ChangeBattery();
	
	rc = new SmartTelevision();
	rc.turnOn();
	rc.turnOff();
	
	//해당인터페이스에는 구현한 메서드만 사용이 가능하다.
	//rc.search("http://www.youtube.com);
	Searchable searchable = new SmartTelevision();
	searchable.search("https://www.youtube.com");
		
	
	
	
	
	
	
	}


}
