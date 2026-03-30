package ex4_setter_getter;

public class CarMain {
	public static void main(String[] args) {
	 Car c = new Car();
	 //잘못된 값을 지정한경우
	 c.setSpeed(-50);
	
	 
	 //올바른 값을 지정
	c.setSpeed(60);
	int speed = c.getSpeed();
	System.out.println("현재속도:" + speed);
	
	
	
	}
	

}
