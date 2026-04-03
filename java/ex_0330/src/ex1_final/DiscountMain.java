package ex1_final;

import java.util.Scanner;

public class DiscountMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("가격: ");
		int price = sc.nextInt();
		
	  Discount discount = new Discount();
	  double result = discount.calculatePrice(price);
	  System.out.println(result);
	}

}
