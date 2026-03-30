package ex_final;

import java.util.Scanner;

public class DiscountMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("상품가격입력: ");
	int price = sc.nextInt();
	
	Discount discount = new Discount();
	double result = discount.calculatePrice(price);
	System.out.println("할인된가격: " + result);
	
	}


}
