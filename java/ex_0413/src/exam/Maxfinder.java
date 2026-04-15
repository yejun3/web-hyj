package exam;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Maxfinder {
	public static void main(String[] args) {
		int [] arr = {1,3,2,3,4,3,2,2,2};
		//숫자별 등장 횟수를 HashMap<Integer,Integer>로 센다.
		//가장 큰 빈도수를 찾는다.
		
		// 숫자 / 나온 횟수로 저장할 예정
				HashMap<Integer, Integer> frequencyFinder = new HashMap<Integer, Integer>();
				
				for (int number : arr) {
					if (!frequencyFinder.containsKey(number)) {
						frequencyFinder.put(number, 1);
					}
					else {
						frequencyFinder.put(number, frequencyFinder.get(number) + 1);
					}
				}
				
				int maxCount = frequencyFinder.get(arr[0]); // 초기값 아무렇게나 하나 지정 / value값 / 숫자의 빈도
				int result = arr[0]; // 초기값 아무렇게나 하나 지정 / key값 / 나오는 숫자 중 가장 자주 나오는 값 저장
				
				// 숫자 / 나온 횟수 저장 완료. 제일 큰 값 비교
				
				// key값만 뽑아서 for문 돌리기
				for (int key : frequencyFinder.keySet()) {
					if (frequencyFinder.get(key) >= maxCount) {
						result = key;
						maxCount = frequencyFinder.get(key);
					}
				}
				
				// entry를 이용해서 할 수도 있음 - 좀 더 가독성있어보임
//				for (Map.Entry<Integer, Integer> entry : frequencyFinder.entrySet()) {
//					if (entry.getValue() > maxCount) {
//						maxCount = entry.getValue();
//						result = entry.getKey();
//					}
//				}
				
				System.out.println("가장 많이 등장한 숫자 : " + result);
				System.out.println("등장 횟수 : " + maxCount + "회");
			 
			
	}
	}