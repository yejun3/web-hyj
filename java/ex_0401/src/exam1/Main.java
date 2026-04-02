package exam1;

public class Main {
	public static void main(String[] args) {
		Order order = new Order(12345678);
		Order.Item item = order.new Item("키보드",2,500000);
		
		order.printOrderInfo(item);
	}
 
}
