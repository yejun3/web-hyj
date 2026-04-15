package exam2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {
		List<Member> members = new ArrayList<>();
	//리스트에 멤버 데이터를 넣는다.
	members.add(new Member("홍길동",25));
	members.add(new Member("박철순",24));
	members.add(new Member("홍길순",28));
	members.add(new Member("홍길동",21));
	
	//20세 이상을 검증하는 람다식
	Predicate<Member> adult = m -> m.getAge() >= 20;
	
	for(Member m : members) 
		if(adult.test(m)) {
			System.out.println(m.getName() + "/" + m.getAge());
		}
	
	
     //Product main
    // 서비스 객체 생성 (상품 관리 역할)
    ProductService service = new ProductService();

    // 상품 등록
    service.addProduct(new Product("P001", "삼각김밥", 1200, 10));
    service.addProduct(new Product("P002", "콜라", 2000, 0));
    service.addProduct(new Product("P003", "도시락", 4500, 5));

    // 전체 상품 출력
    service.printAllProducts();

    // 가격 10% 인상
    // Function<T, R>: 입력 → 출력 구조
    // 여기서는 Product를 받아서 수정 후 다시 반환
    Function<Product, Product> priceIncrease = p -> {
        p.setPrice((int)(p.getPrice() * 1.1));
        return p;
    };

    service.updateProduct("P001", priceIncrease);

    // 문자열 공백 제거
    Function<Product, Product> trimName = p -> {
        p.setName(p.getName().trim());
        return p;
    };

    service.updateProduct("P003", trimName);

    // 재고 있는 상품 조회
    System.out.println("\n=== 재고가 있는 상품 ===");

    // Predicate: 조건 검사 (boolean 반환)
    Predicate<Product> inStock = p -> p.getStock() > 0;

    service.findProductsByCondition(inStock);

    // 품절 상품 삭제
    Predicate<Product> outOfStock = p -> p.getStock() == 0;

    service.deleteProductsByCondition(outOfStock);

    // 삭제 후 전체 출력
    System.out.println("\n=== 품절 상품 삭제 후 ===");
    service.printAllProducts();
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
}

