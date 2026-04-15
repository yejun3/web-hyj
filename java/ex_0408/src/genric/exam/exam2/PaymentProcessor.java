package genric.exam.exam2;

public class PaymentProcessor <T extends Payment> {
	
 T Payment;
 //생성자이름은 클래스명
 public PaymentProcessor(T payment) {
	 this.Payment=payment;
 }

 public void process() {
	 Payment.pay();
 }
 
 
}
