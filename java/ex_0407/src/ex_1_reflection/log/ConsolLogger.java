package ex_1_reflection.log;

public class ConsolLogger implements Logger {
	@Override
	public void log(String message) {
		System.out.println("[consol] 로그 출력: " + message);
	
	}


	
}
