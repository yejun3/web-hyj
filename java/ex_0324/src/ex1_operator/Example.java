package ex1_operator;

import java.util.Scanner;

public class Example {
	private static int used;

	public static void main(String[] args) {
		//상자 하나에는 농구공이 5개가 들어갈 수 있다.
		//만일 농구공이 23개라면 몇개의 상자가 필요한가?
		int ball = 23;
		int box = 5;
		int result = (ball+box-1)/box;
	 System.out.println(result);

		// 사각형의 가로와 세로의 길이를 입력받아 넓이와 둘레 구하기
	
		int a = 5;
	    int b = 4;
	    int result1 = a * b;
	    int result2 = 2*(a+b);
	    System.out.println(result1);
	    System.out.println(result2);
	    
	    Scanner sc = new Scanner(System.in);
		System.out.println(sc);
		
		System.out.print("폭 : ");                                                                            
	    int weight = sc. nextInt();
	  
		System.out.print("높이 : ");                                                                            
	    int height = sc. nextInt();
	    
	    int round = 2*(weight + height);
	    int area = weight * height;
	    
	    System.out.println("넓이 : " + area );
	    System.out.println("둘레 : " + round );
	  
		// 학생은 하루에 일정한 금액의 용돈을 받는다.
		// 하루에 받는 돈 : money
		// 날짜 수 : day
		// 총 받은 용돈에서 사용한 금액 used를 뺀 남은 
	    // 돈을 출력하는 코드 작성하기
	    // 각 값들은 키보드에서 입력받는다.
	   
		
		System.out.print("용돈 : ");                                                                            
	    int money = sc. nextInt();
	    
	    System.out.print("날짜 : ");
	    int day = sc. nextInt();
	    
	    System.out.print("사용한 돈 : ");
	    int uesd = sc. nextInt();

     // 총 용돈 계산
     int total = money * day;
     int remain = total- uesd;

     // 결과 출력
     System.out.println("남은 돈: " + remain + "원");
	    
     //국어,영어,수학에 대한 점수를 키보드에서 입력받는다.
	    //1. 세 과목에 대한 합게 출력하기 
	    //2. 평균 출력하기 (합계/3.0)
	    //3. 세 과목의 점수가 각각 60점 이상이고, 평균이 60점 이상일 때 합격 아니면 불합격 처리
	    // 60 60 60 -> 합격
	    // 30 80 100 -> 불합격
	  
      System.out.print("국어 : ");
	    int kor = sc. nextInt();
	    
	    System.out.print("수학 : ");
	    int math = sc. nextInt();
	    
	    System.out.print("영어 : ");
	    int eng  = sc. nextInt();
	    
	    //총합
	    int totel = kor + math + eng;
	    System.out.println("합계: " + totel);
	    
	    //평균
	    double avg = totel / 3.0;
	    System.out.println("평균: " + avg);
	    
	    //합격여부
	    if (kor >= 60 && eng >= 60 && math >= 60 && avg >= 60) {
         System.out.println("합격");
     } else {
         System.out.println("불합격");}
	    
	  
	    
	
	}
}
