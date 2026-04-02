package ex2_interface;

public class Television implements RemoteControl{

	int volume;
	@Override
	public void turnOn() {
		System.out.println("텔레비전을 켠다.");
	}
	@Override
	public void turnOff() {
	System.out.println("TV를 끕니다.");
	}
	
	
	
	//볼륨을 조절하는 setVolume 메서드를 오버라이딩 하기
	//넘어온 볼륨값이 Max보다 크면 필드를 Max로 세팅
	//넘어온 볼륨값이 작으면 MIN로 세팅 
	//그게아니면 넘어온 볼륨값으로 세팅
	
	@Override
	public void setVolume(int volume) {
		if(volume> RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
			}else if(volume< RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;	
			}else {
				this.volume = volume;	
			}
				
	}














}
