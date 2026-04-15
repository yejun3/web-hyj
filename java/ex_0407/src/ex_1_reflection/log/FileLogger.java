package ex_1_reflection.log;

public class FileLogger implements Logger{
	@Override
	public void log(String message) {
		System.out.println("[file] 로그 저장" + message);
	}

}
