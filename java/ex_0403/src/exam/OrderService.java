package exam;

public class OrderService {
	
	public int calculateTotal(int price, int quantity) throws Exception{
	if(price<0) {
		System.out.println("수량은 1이상 이어야합니다.");
	}
	if (quantity <0) {
		System.out.println("가격은 1 이상이어야 합니다.");
	}
	return price * quantity;
	
	}

}
