package ex2_interface;

public class Audio implements RemoteControl{
	
	int volume;
 @Override 
 public void turnOn() {
	 System.out.println("오디오를 켠다.");
 }


 @Override
public void turnOff() {
	 System.out.println("오디오를 끈다");
}
 
 @Override
public void setVolume(int volume) {
	
}
}
