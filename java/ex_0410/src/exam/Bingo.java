package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bingo {
	// 빙고판 (5x5 배열)
	int[][] bingoBoard = new int[5][5];
	
	// 🔹 생성자
    // → 객체가 만들어질 때 자동 실행
    // → 빙고판을 최초 1회 생성하기 위해 필요
	public Bingo() {
		createBoard(); // 빙고판 초기화
	}
	
	private void createBoard() {
		// 1에서 50 사이의 난수가 있다
		// 5 X 5의 빙고 판에 25개의 숫자를 채운다
		// Scanner sc = new Scanner(System.in);
		
		// 무작위 난수 저장 (Set을 통해 중복 제거)
		Set<Integer> set = new HashSet<Integer>();
		while (set.size() < 25) {
			set.add((int)(Math.random()*50)+1); 
		}
		
		// 🔹 List로 변환 이유
        // → Set은 순서 없음 → index 접근 불가
        // → 배열에 넣으려면 순서가 필요함
		// List로 옮겨담으며 랜덤하게 정렬되게 순서 셔플
		List<Integer> number = new ArrayList<Integer>(set);
		Collections.shuffle(number);  
		
		// 빙고판에 숫자 저장.
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				bingoBoard[i][j] = number.get((i*5)+j);
			} // for ed
		} // for ed
		
		//System.out.println(bingo);
		
		// 출력
		for (int i = 0; i < 5; i++) {
	        for (int j = 0; j < 5; j++) {
	            System.out.printf("%d\t", bingoBoard[i][j]);
	        }
	        System.out.println();
	    }
	} // createBoard ed
	
	// 숫자를 체크하는 메서드
	// 매개변수 : int number
	// 숫자를 넘겨받으면 해당 빙고판의 숫자를 0을 바꾸고 true를 반환
	// 아니면 false를 반환
	public boolean markNumber(int number) {
		for (int i = 0; i < bingoBoard.length; i++) {
	        for (int j = 0; j < bingoBoard[i].length; j++) {
	            // 입력받은 숫자와 배열의 숫자가 일치하는지 확인
	            if (bingoBoard[i][j] == number) {
	                // 일치하면 0으로 바꾸고 true 반환 (메서드 종료)
	                bingoBoard[i][j] = 0;
	                return true;
	            } // if ed
	        }  // for ed
		} // for ed
		return false;
	} // markNumber ed
	
	// 현재 빙고판의 상태 출력하는 printBoard() 메서드 출력
	// 체크된 칸의 숫자는 x로 출력
	public void printBoard() {
		for (int i = 0; i < bingoBoard.length; i++) {
	        for (int j = 0; j < bingoBoard[i].length; j++) {
	            if (bingoBoard[i][j] == 0) {
	                System.out.printf("%s\t","X");
	            } else {
	            	System.out.printf("%d\t",bingoBoard[i][j]);
	            }
	        }  // for ed
	        System.out.println();
		} // for ed
	} // printBoard ed
	
	// 빙고 개수 계산 기능
	// 현재 빙고판에서 완성된 빙고 줄 수를 계산하는 countBingo()메서드 작성
	public int countBingo() {
		int currentBingo = 0;
		
		width : for(int i = 0; i < bingoBoard.length; i++) {
			for (int j = 0; j < bingoBoard[i].length; j++) {
				if (bingoBoard[i][j] != 0) continue width;
			}
			currentBingo++;
		} // width ed
		
		length : for(int i = 0; i < bingoBoard.length; i++) {
			for (int j = 0; j < bingoBoard[i].length; j++) {
				if (bingoBoard[j][i] != 0) continue length;
			}
			currentBingo++;
		} // width ed
		
		boolean diagonal1 = true;
		diagonal1 : for(int i = 0; i < bingoBoard.length; i++) {
			if (bingoBoard[i][i] != 0) {
				diagonal1 = false;
				break diagonal1;
			}
		} // diagonal1 ed
		if (diagonal1) currentBingo++;
		
		boolean diagonal2 = true;
		diagonal2 : for(int i = 0; i < bingoBoard.length; i++) {
			if (bingoBoard[i][4-i] != 0) {
				diagonal2 = false;
				break diagonal2;
			}
		} // diagonal2 ed
		if (diagonal2) currentBingo++;
		
		return currentBingo;
	} // CountBingo ed
	
} // Bingo ed