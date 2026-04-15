package exam2;

//재고관리 프로글매에서 각 클래스의 역할이 뭔지 알면 좋음
//Product 클래스로 만들어진 객체 -> 하나의 상품

public class Product {
	private String code; //제품코드
	private String name; // 제품이름
	private int price;   //제품가격
	private int stock;   //제품 재고
	
	//생성자를 통해 객체 초기화 -> 객체를 만들면서 필드에 값을 넣겠다.(초기화)
	public Product(String code,String name,int price,int stock) {
		this.code=code;
		this.name=name;
		this.price=price;
		this.stock=stock;
	}
//==============================================
	public void setCode(String code) {
		this.code = code;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
//==========================================
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getStock() {
		return stock;
	}
    
	@Override
	public String toString() {
		return ("Product{code = "+ code +","+"name= "+name+","+ " price= "+ price + "," +"stock= "+stock+"}");
	           // String.format("Product{code=%s, name=%s, price=%d, stock=%d}", code,name,price,stock);
	     //이 방식이 좀 더 간편함
	}
	
	
	
	
}
