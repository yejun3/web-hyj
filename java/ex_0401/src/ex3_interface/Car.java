package ex3_interface;

public class Car {
	
		Tire tire = new HankookTire();
		Tire tire2 = new KumhoTire();
		
		
		void run() {
			tire.roll();
			tire2.roll();
			
		}
		
		
		
		
	}

