package ex_4_for;

import java.util.Scanner;

public class ForExample {
	public static void main(String[] args) {
		//지역 변수 : 특정영역 내에서 만들어진 변수는 해당 역역 내에서만 사용할 수 있다.
		//안에서 만든 변수는 바깥에서 사용할 수 없다.
		//바깥에서 만든 변수는 안쪽에서 사용할 수 있다.
				
		for(int i = 1; i<=3; i++) {
			System.out.println(i+" ");
		}
	//for	
	//System.out.println("외부 i의 값 :" + i);
	
	System.out.println("---- ");
		
	//5부터 1까지 출력하기
	for(int i= 5; i>=1; i--) {
		System.out.println(i+" ");
	}
	System.out.println("---- ");

	int sum = 0; // 총 합을 담을 변수 
	for (int i = 1; i<=10; i++) {
		sum += i; //sum =sum +i;
	}
	System.out.println("1~10 까지의 총 합: " + sum);
	System.out.println("---- ");
	
	//1부터 10까지의 3의 배수만 출력하는 for문 작성하기 
	// 1부터 10까지 순회하는 역할 
	for (int i= 1 ; i<=10; i++) {
	if(i%3==0) {
			System.out.println(i+" ");
	}
	}
	System.out.println("---- ");		
			
			//1부터 20까지 홀수만 출력하세요
			for(int i = 1; i <= 20; i+=2) {
				System.out.print(i+" ");
			}
				for(int i = 1; i <= 20; i++) {
					if(i % 2 != 0) {
						System.out.print(i+" ");
					}
				}
			
				
		// 정수형 변수를 하나 초기화한다.
		// 해당 정수에 해당하는 구구단 출력하기
		// 3x1 =3 
	    // ... 3x9 =27
	
				
		int dan = 3; 
	    //내가 반복하고 싶은 것 : 곱하기 9번 for
		for(int i =1; i<=9; i++) {
		if(i % 2!=0) {
		System.out.printf("%d x %d = %d\n",dan, i, dan*i);
	 	
		}
	}
	
		// 키보드에서 정수를 하나 입력받고 
		//1부터 입력받은 정수까지의 총 합 구하기
		//예를 들면 5를 입력받으면 1~5까지의 총합인 15를 구해야한다.
		
		Scanner sc = new Scanner(System.in);
		
	//	System.out.print("정수 : ");
	//	int num = sc. nextInt();
	//	int total = 0;
	//	for(int i = 1; i<= num ; i++) {
	//	total += i;
	//	}
	
		// 10개의 정수를 입력받고 그 수 들 중 짝수가 몇개인지 구하세요
		int count = 0;
		for(int i = 0; i<= 9 ; i++) {
				
			System.out.print("정수 : ");
				int a = sc. nextInt();
				
				if(i % 2 ==0) {
					count++;
				}
				}
		System.out.println("입력받은 짝수는 "+count+"개 입니다.");


	}
	}
