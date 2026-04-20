package exam2;

public class Product {
	private String name;
	private int stock;
	
	public Product(String name,int stock) {
		this.name=name;
		this.stock=stock;
	}

	public String getName() {
		return name;
	}
	public int getStock() {
		return stock;
	}
	
	public void sell(int amount) {
		if(amount>stock) {
			System.out.println("재고가 부족합니다.");
			return;
		}else {
			stock-=amount;
			System.out.println("판매 완료");
		}
	}

	public void printinfo() {
		System.out.println("상품이름: " + name + ", 재고상태: " + stock);
	}
}
