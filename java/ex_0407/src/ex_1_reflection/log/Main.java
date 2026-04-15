package ex_1_reflection.log;

public class Main {
	public static void main(String[] args) {
		//기존에 우리가 사용하던 방식
		//출력방식을 바꾸려면 자바코드를 직접 수정을 해야된다.
		//Logger logger = new FileLogger();
		
		//미리 확정된 객체 생성방식
		//프로그램에 동작 방식이 소스코드에 고정되어있다.
		//Logger logger = new ConsolLogger();
		//logger.log("테스트");
		
		//설정파일 방식
		//프로그램이 실행될때 설정 파일을 읽어봐야 방법을 알수있다.
		Logger logger = LoggerFactory.getLogger();
		logger.log("테스트");
		//출력결과 -> [consol] 로그 출력: 테스트
		//설정 키를 consol로 했음
	}

}
