package genric.exam.exam2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		PaymentProcessor<CardPayment> pay = 
				new PaymentProcessor<>(new CardPayment());	
		
		PaymentProcessor<KaKaoPay> pay2 = 
				new PaymentProcessor<>(new KaKaoPay());
		
		pay.process();
		pay2.process();
		
		
		List<Dog> dogs = new ArrayList<>();
		AnimalPrint ap = new AnimalPrint();
		ap.printAnimal(dogs);
	
	
		
		List<Integer> a = Arrays.asList(1,2,3,4,5);
		List<Double> b = Arrays.asList(1.2,2.2,3.3,4.4,5.5);
	
      System.out.println(Calculator.sum(a));
      System.out.println(Calculator.sum(b));
	
	
	
	}

}


