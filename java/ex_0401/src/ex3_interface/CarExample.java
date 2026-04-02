package ex3_interface;

public class CarExample {
	public static void main(String[] args) {
		Car c =new Car();
	c.tire = new HankookTire();
	c.tire2 = new HankookTire();
	c.run();
	
	c.tire = new KumhoTire();
	c.tire2 = new KumhoTire();
	c.run();
	}

}
