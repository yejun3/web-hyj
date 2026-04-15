package test;

import java.util.Scanner;

public class StudentScoreManager {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름: ");
		String name = sc.next();
		
		System.out.println("java점수: ");
		int java = sc.nextInt();
		
		System.out.println("DB점수: ");
		int DB = sc.nextInt();
	
		System.out.println("HTML: ");
		int HTML = sc.nextInt();
		
	
	int total= java + DB + HTML;
	double average = (double)(total/3);	
	String result =(average>=60)?"합격":"불합격";
	
	if(java<0|java>100|DB<0|DB>100|HTML<0|HTML>100) {
		System.out.println("각 점수는 0 이상 100 이하여야합니다.");
		}else {
	System.out.println("이름: " + name);
	System.out.println("총점: " + total);
	System.out.println("평균: " + average);
	System.out.println("결과: " + result);
		}
	
	
	}

}
