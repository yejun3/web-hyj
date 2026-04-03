package exam1;



public class Main {
	public static void main(String[] args) {
		RemoteControl remoteControl = new RemoteControl();
	   //외부클래스 외부객체명 = new 외부클래스
		RemoteControl.Button button = remoteControl.new Button();
		//외부클래스.내부클래스 내부객체변수명 = 외부객체명. new 내부클래스
		button.press();
		System.out.println("현재 전원상태: " + button.power );
	}

}
