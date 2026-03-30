package ex1_array;

import java.util.Scanner;

public class MultiArrayExample {
	public static void main(String[] args) {
		//2차원 배열 : 1차원 배열을 요소로 갖는 배열
	
		//2차원 배열의 초기화
		int[][]arr= {{1,2,3},{4,5,6},{7,8,9}}; 
	//2차원 배열의 갯수는 3개
		
		//2차원 배열의 선언과 생성
		//1차원 배열과 마찬가지로 길이를 지정해야함
		int[][] ar = new int[2][3];
		//첫번째 가로가 2차원 배열의 요소의 갯수
		//두번째 가로가 2차원 배열 안에 1차원 배열 요소의 갯수
		
		//배열의 각 공간에 접근하는 방법
		//배열명 [요소의 index ] [1차원배열의 index] 
		System.out.println(arr[1][1]);
		//이차원배열의 모든 내용을 출력하려면 이중 for문을 이용할 줄 알아야 한다.
	
	for (int i=0; i<arr.length;i++) {
		for(int j=0; j <arr[i].length; j++){
			//<arr.length : 2차원 배열의 길이
			//arr[i].length:해당 1차원 배열의 길이
			System.out.println(arr[i][j]);
			}
	       }
	
	//각 1차원 배열의 들어가는 데이터의 갯수가 다른 경우
	
	//2차원 배열의 들어가는 요소의 갯수만 일단 지정
	int[][] iAr= new int[3][];
	
	//각 1차원 배열의 들어가는 데이터의 갯수를 따로 지정할 수 있다.
	iAr[0] =new int[1];
	iAr[1] =new int[2];
	iAr[2] =new int[3];                              
	
	iAr[0][0] =100;
	iAr[1][0] =200;
	iAr[1][1] =300;
	iAr[2][0] =100;
	iAr[2][0] =200;
	iAr[2][1] =300;

	//다음 2차원 배열의 모든 요소의 합을 구하시오
	int[][] num = {{1},{2,3},{4,5,6},{7,8,9,10}};
	int count = 0;
	for(int i = 0; i <num.length; i++) {
		for(int j =0; j < num[i].length;j++ ) {
			count+=num[i][j];
			 
		}
	}
	
	System.out.println(count);
	
	
	//학생들의 수학과 영어성적을 등록하는 프로그램이 있다.
	//프로그램을 실행하면 몇몇의 정보를 저장할 것인지 입력한 후
	//입력받은 수 만큼 학생들의 이름과 수학, 영어 성적을 입력받는 프로그램 작성하기
	
    //등록할 인원 수 : 2
    //이름 : 홍길동
    //수학 : 90
    //영어 : 87
    //--------------------
    //이름 : 독고길동
    //수학 : 70
    //영어 : 100
    //--------------------
    //2명 등록 완료!
    //홍길동 90 87
    //독고길동 70 100
	
	try (Scanner sc = new Scanner(System.in)) {
		int n = sc.nextInt();
		
		String[][] str = new String[n][3];
		
		for(int i = 0; i < str.length; i++) {
		   System.out.print("이름 : ");
		   str[i][0] = sc.next();
		   System.out.print("수학 : ");
		   str[i][1] = sc.next();
		   System.out.print("영어 : ");
		   str[i][2] = sc.next();
		   System.out.println("------------------");
		}
		
		System.out.println(str.length+"명 등록완료!");
		for(int i = 0; i < str.length; i++) {
		   for(int j = 0; j <str[i].length; j++) {
		      System.out.print(str[i][j] + " ");
		   }
		   System.out.println();
		}
	}
    int[]scores = {95,71,84,93,87};
	int sum=0;
	for(int score : scores ) {
		sum+=score;
	}
	System.out.println("총합" + sum);
	
	 
	
	}

}
