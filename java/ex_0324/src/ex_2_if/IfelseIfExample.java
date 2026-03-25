package ex_2_if;

import java.util.Scanner;

public class IfelseIfExample {
	public static void main(String[] args) {
		//점수가 100~ 90점 "A"
		//89~80 "b" 79~70 "c" 69~60 "d" 59~0 "F"
		Scanner sc = new Scanner(System.in);
		System.out.println(sc);
		System.out.println("점수: ");
		int score = sc.nextInt();
		System.out.print("평가ㅣ: ");
		if (score < 0) {System.out.println("다시 입력해주세요");}
		else if(score >100) {System.out.println("100 이하만 입력");}
		else if(score >=90) {System.out.println("A");}
		else if(score >=80) { System.out.println("B");}
		else if (score  >=70) { System.out.println("C");}
		else if (score >=60) { System.out.println("D");}
		else {System.out.println("F");}
		
		
	
	}
	
}
