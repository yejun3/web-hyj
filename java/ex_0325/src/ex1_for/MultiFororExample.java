package ex1_for;

public class MultiFororExample {
	public static void main(String[] args) {
		for(int i = 1; i<=3; i++) { 
		//int i = 1->지역변수
		for(int j = 1; j <=3; j++ ) {
			System.out.println(i + " "+ j);
		}
	}
	// 기준이 되는 숫자랑 비교 검사할 때 사용
		
		
    // 두개의 주사위를 던져을 때, 두 눈의 합이 6이되는 모든 경우의 수 출력하기
		//1 5/ 2 4 /3 3 /4 2 /5 1
		
		for(int i = 1; i<=6; i++) {
			for(int j=1; j <= 6; j++) {
				if( i + j==6) {
				System.out.println(i+ " " + j );
				}
				
			}
			
			
			
			
		}
	
	//print()
	//println()
	//1 2 3 4
	//1 2 3 4
	//1 2 3 4
		
	for(int i = 1; i<=3; i++) {// 행의 갯수만큼 반복 (가로)
	 for(int j= 1; j <=4; j++) {// 열의 갯수만큼 반복 (세로)
		 
		 
		 System.out.print(j + " " );
		 }
	 System.out.println(i+ " ");
	}
	
	//1 2  3   4
	//5 6  7   8
	//9 10 11 12
	
	int count = 1;
	for(int i = 1; i<=3; i++) {
	for(int j = 1; j<=4; j++) {
		System.out.print(count++ + " " );
	}
	 System.out.println( );
	 
	 }
	 
	// A B C D 
	// E F G H 
	// I J K L 
	char ch = 'A';
	
	for(int i = 1; i<=3; i++) {
		for (int j=1; j<=4; j++) {
			System.out.printf("%c ",
					ch++);
			}
		System.out.println();
		
	}
	}
}

