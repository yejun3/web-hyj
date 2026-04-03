package exam;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
	Converter converter = new Converter();
 try {
	 System.out.println("문자열: " );
	 String str = sc.next();
	 int num = converter.toInt(str);
	 System.out.println("변환값:" + num);
 } catch(Exception e){
	 System.out.println("숫자로 변환할 수 없습니다.");
 }
	
	
 
 
 Product a1 = new Product("키보드",5000,10);
 Product a2 = new Product("마우스",15000,20);
 Product a3 = new Product("모니터",105000,100);
 
 Product [] product = {a1,a2,a3}; 
 for(Product i : product) {
	 System.out.println(i);
 }
 
 
 
 
 
 
 //반복문으로 배열을 순회하면서 
 //문자열이면 "문자열 데이터:"
 //정수면 "정수데이터 :" 
 //실수면 "실수 데이터:"
 //Employee 객체면 이름과 부서를 출력하세요 
 //instanceof를 사용
 
 Object [] arr = {"java",100,3.14,new Employee("홍길동","개발팀")};
 
 for(Object i : arr ) {
	if(i instanceof String ) {
		System.out.println("문자열 데이터: "+ i );
	}
	if(i instanceof Integer ) {
		System.out.println("정수 데이터: "+ i );
	}
	if(i instanceof Double) {
		System.out.println("실수 데이터: "+ i );
	}
	if(i instanceof Employee) {
		Employee e = (Employee)i;
		System.out.println("사원명 : " + e.name + ", 부서: " +e.dept);
	}
 }

 
 
 
 
 
 
 
 
 
 
 
 
 
	
	}

}
