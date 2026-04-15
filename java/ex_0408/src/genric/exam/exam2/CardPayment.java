package genric.exam.exam2;

public class CardPayment implements Payment {
	@Override
	public void pay() {
		System.out.println("카드결제");
	}

}
