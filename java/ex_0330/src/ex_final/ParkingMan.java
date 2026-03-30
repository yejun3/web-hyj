package ex_final;

import java.util.Scanner;

public class ParkingMan {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("사용시간: " );
		int time = sc.nextInt();
		
		Parking s1 = new Parking ();
		
		int total = s1.caculate(time);
		System.out.println("총 금액:" + total);
	}

	// 키보드에서 입력받아 총 금액 구하기

}
