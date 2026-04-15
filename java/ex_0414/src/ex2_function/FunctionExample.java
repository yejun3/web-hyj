package ex2_function;


import java.util.function.Consumer;
//람다식의 합성 : 여러 함수를 하나의 함수처럼 연결해서 새로운 함수를 만드는 것
import java.util.function.Function;
import java.util.function.Predicate;

//람다식의 결합 : 함수 실행을 순서대로 실행

public class FunctionExample {
	public static void main(String [] args) {
		//java에서는 다음 인터페이스에서 합성을 지원한다.
		//Function<T,R>
		//Predicate<T>
		//Consumer<T>
		
		//핵심 메서드
		//andThen()
		//현재 함수를 실행 -> 다음 함수를 실행한다.
		
	  Function<Integer,Integer> multiply = x -> x*2;
	  Function<Integer,Integer> add = x -> x+3;
			  
	  Function<Integer,Integer> result = multiply.andThen(add);
	  
	  System.out.println(result.apply(5));
	  
	  //5 -> multipy -> 10 -> add -> 13
	  
	  //compose()
	  //괄호안에 함수를 실행하고 -> 앞에있는 함수를 실행
	  
	  result = multiply.compose(add);
	  System.out.println(result.apply(5));
	  //5-> add-> 8-> multipy -> 16
	
	 //Predicate의 결합 (조건 합치기)
	  
	  Predicate<Integer> isPositive = x -> x > 0;
	  Predicate<Integer> isEven = x -> x%2 ==0;
	
	 //and()
	  Predicate<Integer> result2 = isPositive.and(isEven);
	  
	  System.out.println(result2.test(4));
	  System.out.println(result2.test(-2));
	  
	  //isPositive.and(isEven);
	  //x >0 && x %2 ==0
	  
	  //or()
	  //하나라도 조건 만족 
	  Predicate<Integer> result3 = isPositive.or(isEven);
	  System.out.println(result3.test(4));
	  System.out.println(result3.test(-2));
	
	
	  System.out.println("-------------");
	  
	  //negate()
	  // 낫 연산
	  //!(x>0)
	  result2 = isPositive.negate();
	   System.out.println(result2.test(4));
	   
	   //Consumer<t>의 결합
	   //반환값이 없는 함수라서 순서대로 실행하는 결합만 가능
	   
	   //andThen()
	   
	   Consumer<String> print1 = s -> System.out.println("1: " + s);
	   Consumer<String> print2 = s -> System.out.println("2: " + s);
	   
	   Consumer<String> result4 = print1.andThen(print2);
	   result4.accept("Hello");
	   //import java.util.function.Consumer;를 안하고 앞에 쓴 변수명과 겹쳐서 오류가 났음
	   
	   //람다식은 조립이 가능한 함수다.
	
	//문자열을 입력력받아서 다음의 처리를 하는 람다식 함수 파이브라인 만들기
	//1. 공백제거
	//2. 소문자 변환
	//3. "user_" 접두사 붙이기
	
	   String text = "This product is currently out of stock.";
	   
	   Function<String, String> remove = s -> s.replace(" ", "");
	   Function<String, String> lower = s -> s.toLowerCase();
	   Function<String, String> addPrefix = s -> "user_" + s;
	      
	      Function<String,String> pipeline = remove.andThen(lower).andThen(addPrefix);
	     
	      
	      System.out.println(pipeline.apply(text));
	}

}
