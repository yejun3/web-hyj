package Math;

import java.util.Arrays;
import java.util.Scanner;

public class RandomExample {
	public static void main(String[] args) {
		//로또번호 (1~45)을 배열에 넣기
		//키보드 6개의 숫자를 입력받아서 번호맞추기
		//각 배열을 정렬한 뒤 Arrays equals()활용하기
		int [] lotto = new int[6];
		for(int i =0; i<6; i++) { //0<=x<45 0~44숫자 +1
			lotto[i] = (int)(Math.random()*45)+1;
			
			for(int j =0; j<i; j++) {//중복 체크 
				if(lotto[i]==lotto[j]) {
					i--;
					break;// 같은 번호일 시 멈춘다.
				}
			}
		}
		Arrays.sort(lotto); //  배열 오름차순
		
		Scanner sc = new Scanner(System.in);
	
		int [] number = new int[6];
		
		for(int a =0; a<6; a++) {
			System.out.println("번호입력: ");
			number[a]= sc.nextInt();
		}
		
		
		Arrays.sort(number);
		
		if (Arrays.equals(lotto, number)) { // sort 해둔 lotto와 guess 배열 내용이 같으면
			System.out.println("로또에 당첨되셨습니다!");
			System.out.println(Arrays.toString(lotto));
		}
		else {
			System.out.println("로또에 당첨되지 않았습니다.");
			System.out.println("로또 번호 : " + Arrays.toString(lotto));
			System.out.println("입력한 번호 : " + Arrays.toString(number));
		}
	
	
	}

}
