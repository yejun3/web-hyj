package exam2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ProductService {
	
	//외부에서 접근 못하게 private 써주는 게 좋음
	//제품을 담기위한 리스트
	private List<Product> products = new ArrayList<>();
	
	//1) 상품 등록
	public void addProduct(Product product) {
		for(Product p : products) {
		    //오류났던 이유:products.getCode()라고 썻음
			//비교대상은 products 리스트안에 product 각 요소의 코드
		if(p.getCode().equals(product.getCode())) {
    //if(findBycode(product.getCode())!=null)로 쓸수도 있음  	
			System.out.println("이미 존재하는 상품 코드입니다.");
		return;	
		}
	   }
		products.add(product);
	}
	
	//전체 상품 조회
	public void printAllProducts(){
	System.out.println("=====전체상품목록=======");
	products.forEach(product -> System.out.println(product));		
	}
	
	//3) 상품 코드로 조회
	public Product findByCode(String code) {
	for(Product product : products) {
	if(product.getCode().equals(code)) {	
	  return product; //찾으면 찾은 Product c를 반환
	 }
	}
	//오류 원인 else { return null; }으로 null을 루프 안에 넣은 것
	//이렇게 하면 첫 번째 상품이 찾는 상품이 아닐시 첫번째 상품만 검사하고 끝남
	//if 문에 못들어갈 수도 있으니 루프 밖에서 return null;을 작성해야 전체를 검사
	return null; //못 찾을시 없음
   }
	
	
	//4) 상품 정보 수정
    public void updateProduct(String code, Function<Product, Product> updater) {
    //해당 상품 찾기                          //Consumer<Product> updater
    Product product	= findByCode(code);
    //product 객체는 code값으로 찾은 상품이라고 초기화	
    
	
	if(product==null) {
		System.out.println("상품이 존재하지 않습니다.");
		return; // 상품이 없는데 적용시키면 안되니 강제로 메서드 종료
	}
	// 코드로 정상적으로 찾았으면 updater 적용시키기
			updater.apply(product);
         // updater.accept(product); Consumer쓸 시 반환값은 없고 그냥 실행
   }
   
    //5) 조건에 맞는 상품 조회
    public void findProductsByCondition(Predicate<Product> predicate) {
    	// Predicate: true/false 조건 검사 함수
        // → 조건을 외부에서 전달받아 유연하게 처리
        for (Product product : products) {
            if (predicate.test(product)) { 
                System.out.println(product.toString());
            }
        }
    }

    //6) 조건에 맞는 상품 삭제
	public void deleteProductsByCondition(Predicate<Product> predicate) {
		products.removeIf(predicate);
		// removeIf:
        // → Predicate 조건이 true인 요소를 자동으로 제거
        // → 내부적으로 반복문을 돌면서 삭제 처리
	
	
	}


}







