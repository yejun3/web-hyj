package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example {
	public static void main(String[] args) {
		List<Integer>numbers = Arrays.asList(3,5,7,8,10,4,1,2,6,9,1);
	
	//짝수만 골라 10을 더한뒤 출력

	numbers.stream()
	.filter(x-> x%2==0)
	.map(x->x+10)
	.forEach(x->System.out.println(x+" "));
	
	List<String> words = Arrays.asList("java", "spring", "react", "db", "server");
	
	//문자열의 길이가 5이상인 문자열만 남긴 뒤
	//대문자로 변환해서 출력
	
	words.stream()
	.filter(x-> x.length()>=5)
	.map(x->x.toUpperCase())
	.forEach(x->System.out.print(x+" "));
	
	
	List<Integer> orders = Arrays.asList(12000, 80000, 45000, 50000, 99000, 30000);
	long count = orders.stream()
	            .filter(x->x>50000)
	            .count();
	System.out.println("50000이상 주문 갯수"+ count);
	
	List<Integer> ages = Arrays.asList(21, 35, 17, 42, 63, 15);

	boolean result = ages.stream()
			.anyMatch(x->x>100);
			System.out.println(result);
	
			result = ages.stream()
	        .allMatch(x-> x>=20);
			System.out.println(result);
			
			result = ages.stream()
			        .anyMatch(x-> x<20);
					System.out.println(result);
					
	List<Integer> scores = Arrays.asList(55, 90, 82, 67, 99, 80, 73);
	List<Integer> scores2 =new ArrayList<>();
	
	scores2 = scores.stream()
			 .filter(x-> x>=80)
			 .sorted((a,b)->b-a)
			 .collect(Collectors.toList());
	         System.out.println(scores2);
	
	
	List<Product> products = Arrays.asList(
			new Product("마우스", 8000),
			new Product("키보드", 30000),
			new Product("모니터", 150000),
			new Product("노트", 2000)
			);

	
    Map<String, Integer> productMap = new HashMap<>();

    productMap=(Map<String, Integer>) products.stream()
    		.filter(p-> p.getPrice()>=10000)
    		.collect(Collectors.toMap(
    				Product::getName,
    				Product::getPrice));
    
    //   for (Product p : products) {
//        if (p.getPrice() >= 10000) {
//            productMap.put(p.getName(), p.getPrice());
//        }
//    }


    System.out.println(productMap);
	}
}
