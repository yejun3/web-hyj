package product;

public class Product {
		private String name;
		private int price;
		private int quantity;
		
		
		public Product(String name,int price,int quantity) {
			this.name=name;
			this.price=price;
			this.quantity=quantity;
		}
	
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
		
	public void setQuantity(int quantity) {
		this.quantity=quantity;
	}
		public int getTotalPrice() {
			return price*quantity; 
		}
		
		@Override
		public String toString() {
			//return name +"("+ price +")"+ "x"+ quantity + "개";
		return String.format("%s(%원) x %d개", name,price,quantity);
		}
	}



