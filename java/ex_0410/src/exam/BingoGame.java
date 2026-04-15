package exam;
//빙고의 게임 프로세스
//게임의 시작, 빙고 숫자 입력

import java.util.Scanner;

public class BingoGame {
	//빙고 객체를 필드로 선언하세요 
	//사용자에게 입력받기위한 Scanner 객체를 필드로 선언하세요
	//생성자에서 빙고객체를 만드세요
	//Scanner 객체도 생성하세요
	
	private Bingo bingo;
	private Scanner sc;
	
	public BingoGame() {
		this.bingo = new Bingo();
		this.sc = new Scanner(System.in);
	}
	   
	   
	//while문 조건이   true인 이상 계속 반복
	public void start() {
		
	   System.out.println("게임을 시작합니다.");
		
	    while (true) {
		//1단계
		//현재 빙고판을 출력합니다.
		bingo.printBoard();

		//1-1단계 
		//현재 빙고 개수를 계산하여 출력하세요
		//현재 빙고 갯수 : x
		int bingocount = bingo.countBingo();
		System.out.println("빙고 현재 갯수" + bingocount );
		
		
		//1-2단계
		//현재 빙고 갯수가 3개 이상이면 게임을 종료하시오
		//"3빙고 완성 게임 종료" 
		if (bingocount >= 3) {
            System.out.println("게임을 종료합니다.");
            break;
		}
            //2단계
		//사용자에게 숫자를 입력받습니다.
		System.out.println("숫자를 입력하세요: ");
		int number = sc.nextInt();
		 
		// 3단계: 입력한 숫자가 빙고판에 존재하면 체크
        boolean result = bingo.markNumber(number);
	
      //4단계
 	  //숫자가 존재한다면 "X를 체크했습니다." 라고 출력하기
        if (result) { //result 반환값이 true면 체크확인 문자가 출력
            System.out.println(number + "X를 체크했습니다.");
        } else {
      // 5단계: 숫자가 없으면 메시지 출력
           System.out.println("빙고판에 없는 숫자입니다.");
        }
	
	 }
	

 }	

}
