package ex4_interface;

public class SmsNotification implements SnS {
	@Override
	public void send(String message) {
		System.out.println("[SMS] 인증번호를 전송합니다.");
	}

}
