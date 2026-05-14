package main;

import java.util.Scanner;

import dao.BookDAO;
import dao.CustomerDAO;
import dao.RentalDAO;
import dto.BookDTO;
import dto.CustomerDTO;

public class Main {
	public static void main(String[] args) {
		//박민수 010-3333-3333 회원 추가하기
	 CustomerDAO customer_dao = new CustomerDAO();
	 BookDAO book_dao = new BookDAO();
	 RentalDAO rental_dao = new RentalDAO();
// customer_dao.insertCustomer(new CustomerDTO("박민수","010-3333-3333"));
	
//    book_dao.insertBook(new BookDTO(1, "자바의 정석", "남궁성", 5));
//    book_dao.insertBook(new BookDTO(2,"이것이 자바다","신용권",6));
    
  //  book_dao.findAllBooks();
    
//  rental_dao.rentalBook(9, 1);
//  rental_dao.findRentalList();
	
	Scanner sc = new Scanner(System.in);
	
	 while(true) {
         System.out.println("도서 대여 관리 프로그램");
         System.out.println("1. 고객 등록");
         System.out.println("2. 도서 등록");
         System.out.println("3. 도서 전체 조회");
         System.out.println("4. 도서 대여");
         System.out.println("5. 전체 대여 목록 조회");
         System.out.println("6. 고객별 대여 목록 조회");
         System.out.println("7. 재고부족 도서 조회");
         System.out.println("0. 종료");
         System.out.print("메뉴 선택 : ");
         int menu = sc.nextInt();
         sc.nextLine();
         
         switch(menu) {
         case 1:
            //고객 정보를 입력받아서 customer테이블에 등록하기
             System.out.print("고객 이름 : ");
             String name = sc.nextLine();

             System.out.print("전화번호 : ");
             String phone = sc.nextLine();

             customer_dao.insertCustomer(
                     new CustomerDTO(name, phone));
             break;
             
         case 2:
            //도서 정보(제목,저자,개수)를 입력받아서 book테이블에 저장하기
             System.out.print("도서 번호 : ");
             int bookId = sc.nextInt();
             sc.nextLine();

             System.out.print("제목 : ");
             String title = sc.nextLine();

             System.out.print("저자 : ");
             String author = sc.nextLine();

             System.out.print("재고 수량 : ");
             int stock = sc.nextInt();
             sc.nextLine();
             
             book_dao.insertBook(
                     new BookDTO(bookId, title, author, stock));

             break;
         case 3:
            //도서 전체 조회하기
             book_dao.findAllBooks();
             break;

         case 4:
            //고객번호와 도서번호를 입력받아 도서 대여하기
             System.out.print("고객 번호 : ");
             int customerId = sc.nextInt();
             sc.nextLine();
             
             System.out.print("도서 번호 : ");
             int rentalBookId = sc.nextInt();
             sc.nextLine();
             
             rental_dao.rentalBook(customerId, rentalBookId);

             break;
         case 5:
            //전체 대여 목록
        	  rental_dao.findRentalList();
              break;
         
         case 6:
        	 //고객별 대여 목록 조회
        	 // 고객 id를 입력받아서 고객명, 제목, 빌린날짜 순으로 출력하기
        	System.out.println("고객 번호: ");
        	int rental_customerId = sc.nextInt();
        	sc.nextLine();
        	
        	rental_dao.findCustomerRentalList(rental_customerId);
        	
        	break;

         case 7:
        	 //재고 부족 도서 조회 
        	 // 재고가 2권 이하인 도서를 조회
        	 // findLowStockBooks()
        	 book_dao.findLowStockBooks();
          break;
         
         case 0:
            //프로그램 종료
            System.out.println("프로그램 종료");
            sc.close();
            return;
         
         default:
              System.out.println("잘못된 메뉴입니다.");
         }
      }
      

      


    
	
	
	}

}
