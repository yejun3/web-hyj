package ex4_setter_getter;

public class Car {
	
	//private으로 선언된 필드는 외부에서 접근이 안된다.
	private int speed;
	private boolean stop;
	
	//setter&getter
	//private으로 선언된 필드에 접근할 수 있도록 해주는 메서드
	
	//speed의 값을 세팅해주는 setSpeed 메서드 만들기 
	//속도값은 호출할때 받아온다.
	//0보다 크면 필드에 세팅한다.
	//Speed의 값을 반환하는 getSpeed 만들기 
	
	public void setSpeed (int speed) {
		if(speed>0) {
			this.speed =0;
			return;
		}else {
			this.speed = speed;

		}
	}
	//Speed의 값을 반환하는 getSpeed 만들기 
	public int getSpeed(){
		return speed;
	}	
	public void setStop(boolean stop){
		this.stop = stop;
		if(stop==true) {
			this.speed=0;
		}
	
	}
	
	
}


