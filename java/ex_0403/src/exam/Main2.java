package exam;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Converter2 converter = new Converter2();
		OrderService service = new OrderService();
		
		try {
			System.out.println("상품가격입력: " );
			 String priceStr = sc.nextLine();

	            System.out.print("수량 입력: ");
	            String quantityStr = sc.nextLine();

	            int price = converter.toInt(priceStr);
	            int quantity = converter.toInt(quantityStr);

	            int total = service.calculateTotal(price, quantity);

	            System.out.println("총 금액: " + total);

	        } catch (NumberFormatException e) {
	            System.out.println("숫자 형식 오류");
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }

	        sc.close();
		}
	}


