package product;

import java.util.ArrayList;
import java.util.List;


public class Cart {
		private List<Product> products = new ArrayList<>();
	
	//상품추가 (같은 상품이 들어오면 수량만 증가)
		public void addProduct(String name, int price, int quantity){
			for(Product p : products) {
				if(p.getName().equals(name)) {
					p.setQuantity(p.getQuantity()+quantity);
					System.out.println("기존 상품 증가 완료");
				   return;	
				}
			}
	       //넘어온 제품을 추가
			products.add(new Product(name,price,quantity));
			System.out.println("상품추가완료");
	}

		 //장바구니가 비어있으면 "장바구니가 비어있습니다." 출력하고 종료
		//모든 상품을 출력하기
	     //장비구니 출력
		public void printCart() {
	     if(products.size()==0){
	    	System.out.println("장바구니가 비어있습니다."); 
	     return; //메서드를 끝내는 용도로 사용 매서드 자체를 빠져나감
	     }
	     for(Product p : products) {
	    	System.out.println(p); 
	     }
		}  
	    //총 금액계산
	     public void printTotalPrice() {
	    	 int sum =0;
	    	 for(Product p : products) {
	 	    	sum+= p.getPrice()*p.getQuantity(); 
	 	     }
	    	 System.out.println("총액: " + sum);
	     }
		// 제품삭제
	     
	    public void removeProduct(String name) {
	    	for(Product p : products) {
	    	if(p.getName().equals(name)){
	    		products.remove(p);
	    		System.out.println("상품 삭제완료");
	    	return;
	    	}
	    }
	    	System.out.println("해당 상품이 없다.");
	  }


}	

