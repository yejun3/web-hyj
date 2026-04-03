package ex1.innerclass.hiddenclass;

public class Home {
	//인터페이스는 객체를 만들 수 없다.
	//인터페이스를 구현하는 클래스를 만들어야한다.
	
	private RemoteControl rc = new RemoteControl() {
		
		@Override
		public void turnOn() {
			System.out.println("tv를 킵니다.");
		}
		
		@Override
		public void turnOff() {
			System.out.println("tv를 끕니다.");	
		}
	
	};

	
public void use1() {
	rc.turnOn();
	rc.turnOff();
}

	
public void use3(RemoteControl rc) {
	rc.turnOn();
	rc.turnOff();	
}



}
