package ex_2_While;

import java.util.Scanner;

public class DowhileExample {
	public static void main(String[] args) {
		System.out.println("메세지를 입력하세요");
		System.out.println("프로그램을 종료하려면 q를 입력하세요");
	Scanner sc = new Scanner(System.in);
	String inputString;
	
	do {
		System.out.println(">");
		inputString = sc. nextLine();
		System.out.println(inputString);
	}while(!inputString.equals("q"));
	//-------------
	//사용자가 비밀번호를 입력한다.
	//비밀번호가 1234와 같을때까지 입력
	//단 5번 틀리면 접속차단 후 종료
	//성공하면 로그인 성공 출력
	 int password = 1234;
     int input;
     int count = 0;

     do {
         System.out.print("비밀번호 입력: ");
         input = sc.nextInt();
         count++;

         if (input == password) {
             System.out.println("로그인 성공");
             return;
         }

     } while (input != password && count < 5);

     System.out.println("접속 차단 (5회 오류)");

	  
   
    // 정수를 입력받는다. //다시풀기
    // 입력받는 수를 뒤집어서 출력하세요
    //1234
	//4321
	int original;
	int reverse =0 ;
	System.out.println("정수: ");
	original = sc.nextInt();
	
	do { 
		reverse = reverse*10 + original %10;
		original /=10;
		
	}while(original !=0);
	System.out.println("뒤집은 수: " + reverse);
	
		   
		   
		   
	
	}

}
