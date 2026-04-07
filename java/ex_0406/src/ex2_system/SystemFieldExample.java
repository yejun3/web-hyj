package ex2_system;

import java.util.Scanner;

public class SystemFieldExample {
	public static void main(String[] args) {
		//System.out
		//표준출력장치
		//콘솔에 메세지를 출력할 때 사용
		System.out.println(System.out);
		//출력결과: java.io.PrintStream@439f5b3d 주소갑이 나옴
		
		//Sytem.in
		//표준입력장치
		//키보드에서 입력받을 때 사용
		System.out.println(System.in);
		
		//System.err
		//표준에러출력장치
		//오류 메세지를 출력할때 사용
		System.out.println(System.err);
	
	Scanner sc = new Scanner(System.in);
	
	System.out.println("1. 일반출력은 System.out");
	System.out.println("2. 에러출력은 System.err");
	System.out.println("3. 이름을 입력하세요: ");
	String name =sc.nextLine();
	System.out.println("입력한 이름: " + name);
	
	}

}
