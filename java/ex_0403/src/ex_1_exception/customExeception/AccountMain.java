package ex_1_exception.customExeception;

public class AccountMain {
	public static void main(String[] args) {
		Account account = new Account();
		account.deposit(100000);
		System.out.println("예금액: " + account.getBalance(0));
	
	try {
		account.withdraw(30000);	
	}catch(Exception e){
		String message = e.getMessage();
		System.out.println(message);
	}
	}
}
