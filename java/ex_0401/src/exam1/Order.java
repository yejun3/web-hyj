package exam1;

public class Order {
	
	int ordernumber;
	
	public Order(int ordernumber) {
		this.ordernumber= ordernumber;	
	}
	
	void printOrderInfo(Item item){
		System.out.println("주문정보: " + ordernumber );
		item.printInfo();
	}
	
	public class Item {
		String name;
		int count;
		int price;
		
		public Item(String name,int count,int price) {
			this.name=name;
			this.count=count;
			this.price=price;
		}

		void printInfo(){
			System.out.println("상품명: "+ name + " 수량: " +  count + " 가격: " +  price);	
		}
		
		
		
	}
			







}

