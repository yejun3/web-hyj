package ex4_interface;

public class Main {
	public static void main(String[] args) {
		SnS[]sns= {
				new EmailNotification(),new SmsNotification()};
		for(SnS i:sns) {
			i.send(null);
		};
	
	
	
	
	}
		

}
