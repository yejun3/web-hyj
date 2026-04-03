package ex_1_exception;

import java.util.Scanner;

public class Exam {
	public static void main(String[] args) {


		try { //키보드에서 정수를 입력받고 정수이외의 값이 입력되었다면
			//"정수만 입력가능" 메세지 출력하기
			Scanner sc = new Scanner(System.in);
			System.out.println("정수입력: ");
		    int a = sc.nextInt();
    	    //내가 했더니 오류난 부분
		    //스캐너부분을 부분을 try 외부에 써서 예외처리가 되지 않았음
    		System.out.println(a);
    	}catch(Exception e) {
    		System.out.println("정수만입력가능");
   
    	}
		
		String [] fruits = {"사과","바나나","포도","복숭아"};
		//인덱스를 입력받는다.
		//해당위치가 아니면 "숫자를 입력합니다. 출력
		//범위를 벗어난 인덱스면 "존재하지 않는다" 출력 
		try {
			Scanner sc = new Scanner(System.in);
			int index = sc.nextInt();
			System.out.println("숫자:" +fruits[index]);
			}catch(Exception e) {
			System.out.println("존재하지않는다.");
		}
	
		
    	
    
	

	
	
	
	
	
	}

}
