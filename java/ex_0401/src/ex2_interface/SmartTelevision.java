package ex2_interface;

// 서로 다른 인터페이스에 정의된 추상 메서드를 구현해야 한다.
public class SmartTelevision implements RemoteControl,Searchable {
	
	@Override
	public void search(String url) {
		System.out.println(url + "을 검색합니다.");
	}
	
	@Override
	public void setVolume(int volume) {
		
	}
	@Override
	public void turnOff() {
	  System.out.println("TV를 끕니다.");
		
	}
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}

 
}
