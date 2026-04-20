package exam2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("제품이름: ");
		String name = sc.next();
		System.out.println("재고상태: ");
		int stock= sc.nextInt();
		Product p = new Product(name, stock);
	 
		p.printinfo();
		
		p.sell(3);
		p.printinfo();
		p.sell(10);
		p.printinfo();
	
	    sc.close();
	}

}
