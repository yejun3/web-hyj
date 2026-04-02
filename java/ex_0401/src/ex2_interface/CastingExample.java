package ex2_interface;

public class CastingExample {
	public static void main(String[] args) {
		
		//자동타입변환
		Vehicle vehicle = new Bus();
		
	vehicle.run();
	//vehicle.checkFare(); (x)
	//강제타입 변환후 호출
	Bus bus = (Bus) vehicle;
		
	}

}
