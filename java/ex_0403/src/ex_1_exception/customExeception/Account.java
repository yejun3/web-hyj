package ex_1_exception.customExeception;

public class Account {

	private long balance;//잔액
	
	public Account() {};
		
   // 잔액을 반환하는 getter
	
	public long getBalance(int money) {
		return balance;
	}
	//돈 전달받아 입금하는 메서드 deposit
	public void deposit(int money) {
     balance +=money; // 잔액합산
	}

	//인출
 public void withdraw(int money) throws Exception{
	 if (balance< money) {
		 throw new Exception("잔고부족: " + (money-balance)+ "원 모자름");
	 }
 }
 
}
