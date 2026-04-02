package ex4_interface;

public class EmailNotification implements SnS {
	@Override
	public void send(String message) {
		System.out.println("[EMAIL]회원가입을 환영합니다.");
	}

}
