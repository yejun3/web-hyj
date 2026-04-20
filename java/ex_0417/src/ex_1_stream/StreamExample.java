package ex_1_stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		// 스트림을 사용하기 위해서는 스트림 객체를 생성해야 함
		
				// 컬렉션에서 생성하는 방법
				List<String> list = Arrays.asList("A", "B", "C");
				Stream<String> listStream = list.stream();
				
				Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
				Stream<Integer> setStream = set.stream();
				
				// Map은 Collection 인터페이스가 아니므로, stream() 메서드가 존재하지는 않는다.
				
				// keySet()
				// key만 스트림으로 만들고 싶을 때 사용
				Map<String, Integer> map = new HashMap<>();
				map.put("사과", 1000);
				map.put("바나나", 1500);
				map.put("포도", 3000);
				map.put("오렌지", 2500);
				map.put("귤", 500);
				
				map.keySet().stream();
				
				// values()
				// 값만 스트림으로 만들고 싶을 때 사용한다.
				map.values().stream();
				
				
				// entrySet()
				// 키와 값을 둘 다 써야될 때 사용
				map.entrySet().stream();
				
				// 배열에서 생성하는 방법
				String[] fruits = {"사과", "바나나", "포도"};
//				String[] fruits = new String[5];
//				fruits[0] = "사과";
				
				// Arrays.stream(배열)을 통한 스트림 생성
				Arrays.stream(fruits);
				
				// Stream.of()를 통한 스트림 생성
				Stream.of(fruits);
				
				// 기본 타입 변수는 일반 Stream이 아니라 전용 스트림을 사용함.
				// 일반스트림을 쓰게 되면 int -> Integer처럼 변환되는 작업을 거쳐야 하기 때문에(Wrapping)
				// 성능 저하가 발생할 수 있다.
				
				// int -> IntStream
				// long -> LongStream
				// double -> DoubleStream
				
				int[] iArr = {1,2,3};
				
				IntStream iStream = Arrays.stream(iArr);
				
				// IntStream.of()를 사용하여 직접 생성하기
				IntStream iStream2 = IntStream.of(1,2,3);
				
				// 범위 기반 생성
				// range(시작값, 끝값)
				IntStream.range(1, 5); // 4까지만 생성
				
				// rangeClosed(시작값, 끝값)
				IntStream.rangeClosed(1, 5); // 5까지 생성
				
				// iterate()
				IntStream.iterate(0, n -> n+1); // 반복을 해서 진행해야함
				
				// random(난수생성)
				int rand = new Random().nextInt(45) + 1; // 1~45까지의 랜덤난수
				
			}
		}