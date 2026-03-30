package ex3;

import java.util.Scanner;

public class BreakExample {
	public static void main(String[] args) {
		// 1~45 난수 뽑기
/*		int random = (int)(Math.random()*45+1);
		Scanner sc = new Scanner(System.in);
		int answer;
		while(true) {
			System.out.println("정답 : ");
			answer = sc. nextInt();
			//입력받은 answer랑 난수랑 일치하면
			// 반복문을 빠져나가게 해 줘
			if(answer == random) {
				break;
				
			}
		}*/
	
	//updown 게임 for 문을 이용해 만들기
	// 기회10번
		//중간에 정답맞추면 반복문 종료 "정답이니다."출력
		//입력값이 정답보다 작으면 "up" 크면 down
		//10번만에 정답을 맞추지 못하면 "정답을 맞추지 못했습니다."

		
//		int num = sc. nextInt();
//		int magicnumber = (int)(Math.random()*45+1);
		
		
		
	
//		for(int i=0; i<10; i++ ) {
//			System.out.println("숫자: ");for(int i = 0; i < 10; i++) {
//			System.out.print("찾는 숫자를 입력 >> ");
//			int guess = sc.nextInt();
//			
//			if(guess == magicNumber) {
//				System.out.println((i+1)+"번째에 맞췄습니다.");
//				isMatched = true;
//				break;
//			} else if(guess < magicNumber) {
//				System.out.println("up");
//			} else if(guess > magicNumber) {
//				System.out.println("down");
//			}
//		}
//		
//		if(!isMatched) {
//			System.out.println("정답을 맞추지 못했습니다.");
			
	//		}
	
		
		
		
		//라벨					
	outer:for(int i = 1; i<=5; i++) {
		for(int j =1; j<=5; j++ ) {System.out.println(i + " "+ j);
			if(j==3) {
			 break outer;
			}
		}
	}
		
		
	}

}
