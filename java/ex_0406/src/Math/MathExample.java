package Math;

import lombok.ToString;

public class MathExample {
	public static void main(String[] args) {
		//ceil() 올림
		double v1 = Math.ceil(5.3);
		System.out.println(v1);
	
		//floor()내림
		double v2 = Math .floor((5.3));
		System.out.println(v2);
		
		//abs(); 절대값
		double v3 = Math.abs(-10);
		System.out.println(v3);
	
		//max() 최댓값찾기
		long v4 = Math.max(3,7);
		System.out.println("더 큰 수: " + v4);
		
		//min 최솟값 찾기
		long v5 = Math.min(3, 7);
		System.out.println("더 작은 수 : " + v5);		
	
	int [] arr = { 5,2,9,1,7};
	//max ,min을 활용하여 최댓값과 최소값 구하기
   
	
	int max = arr[0]; //인덱스 첫번째 값을 초기화
	int min = arr[0]; 
	
	for (int number :arr) {
		if(number>=max) { 
			//현재 number값이 현 최댓값 max보다 높으면 반복
			max = number;
		}else if(number<min) {
			min = number;
		}
   }
	 System.out.println("최대값: " + max );
	 System.out.println("최소값: " + min );	

	
	// round()반올림
	//무조건 소수 첫째자리에서 반올림
	System.out.println(Math.round(3.15));
	
	//소수 셋째자리 반올림
	double pi= 3.14159;
	double result2 = Math.round(pi*100)/100.0;	
	// 원하는 위치에서 반올림을 할 수 있게 10의 제곱수를 곱하고, 반올림 후에 곱한 만큼 나눠줌
	System.out.println(result2);
	
	//pow()제곱근 
	System.out.println(Math.pow(2.3, 2.3));
	
	System.out.println(Math.sqrt(9.0));
	
	// 10~20정수를 난수로 뽑음
	//random() : 0.0<= x <1.0
	// random()*11 : 0.0<<= x <11.0 사이의 수가 나오ㅓㅁ
	int num = (int)(Math.random()*11)+10;
	System.out.println(num);
	
	//두 점 사이의 거리
	//x1 = -5, x2 =8
	double x1 = -5;
	double x2 = 8;
	double length = Math.abs(x2 - x1);
	System.out.println(length);
	
	
	
	//물건 53개를 한 박스 8개씩 담으려고 한다
	//필요한 박스의 갯수
	
	int box = 8;
	int object =53;
	
    // 정수형끼리 나눈값을 실수형으로 전환하고 올림을 한 값을 정수형으로 바꿔줄 것
	int count = (int)Math.ceil((double)object/box);
	System.out.println(count);
	

	}

}
