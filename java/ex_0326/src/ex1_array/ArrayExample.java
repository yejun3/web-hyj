package ex1_array;

import java.util.Scanner;

public class ArrayExample {
	public static void main(String[] args) {
	
		char[] cards = {'1','L','O','2','V','3','E'};
		String myword = " ";
		// 배열에서 문자만 뽑아서 단어 만들기
	for (int i=0; i<cards.length; i++) {
		int word = cards[i];
		if ((word>=65 && word<=90) || (word>=97 && word<=122)) {
		myword += (char)word;
	}
	}
	System.out.println("단어: " + myword );
	




//변수 money에 10 ~5000원 사이의 난수를 발생시켜 넣는다. 
// 단 1의 자리 숫자는 반드시 0이 되도록 한다.
//발생된 난수 money를 동전으로 바꾸면 각 동전이 몇 개 필요한지 코드 작성
//가능한 적은 수 동전
	int [] coin = {500,100,50,10};
	int money = ((int)(Math.random()*500 + 1))*10;
			System.out.println("잔돈: " + money);
	for(int i=0; i < coin.length; i++) {
		int a= money / coin [i];
		System.out.println(coin[i]+ "원: " + a);
		money = money % coin[i];
		
	}
	
	
	//키보드에서 배열의 길이를 입력받는다.
	//입력받은 배열의 길이만큼 알파벳을 요소로 넣는다.
	//배열의 길이 : 5 
	// ABCDE
	//배열의 길이가 : 10
	//ABCDEFGHIJ
	//배열의 길이만큼 반복하여 요소에 알파벳 넣기(아스키 코드 활용)
	
	Scanner sc = new Scanner(System.in);
	
	int num = sc.nextInt();
	System.out.println("배열길이: " + num);
	//길이가 num 인 문자형배열
	
	char [] arr;
	arr= new char[num];
    
	
	for(int i=0; i< arr.length; i++) {  
	
		
	}
	
	//로또번호 구하기
	//1~45사이의 난수를 발생시켜 로또번호 6자리를 만드는 코드작성하기
	//번호가 중복되는지 비교하기
	int [] number = new int[6];
	//배열길이만큼 반복
	outer:for(int i=0; i<number.length; i++) {
	//난수를 뽑아 배열저장
		number[i] = (int)(Math.random()*45 +1);
	
	//중복이 있는지 검사
	for(int j=0; j< i; j++) 
	
			if(number[i] == number[j]) {
		continue outer;
		}
	}

		System.out.println("로또번호: " + number);
	
		
	
	
	}
	}

