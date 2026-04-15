package ex_1_reflection.log;

import java.io.FileInputStream;
import java.util.Properties;

//리플렉션 + 설정파일 
//설정파일을 읽고 리플렉션으로 객체를 생성해서 반환하는 공장역할

//로그를 출력하는 프로그램을 만들되 로그출력방식은 코드가 아니라 설정파일에 따라서 
// 만들게 하기 위함  
//개발중에는 콘솔에 출력
//운영환경에서는 파일에 저장
//어떤 시스템에서는 dp 에저장
public class LoggerFactory {

	public static Logger getLogger() {
		Properties prop = new Properties();
		try {
			//load : 설정파일을 불러온다.
			//config.properties 설정파일을 가져옴
			prop.load(new FileInputStream("config.properties"));
		//클래스 이름 가져오기 
		//config.properties 설정파일에서 LoggerClass 클래스이름 가져옴
		String ClassName = prop.getProperty("LoggerClass");
		
		//리플렉션을 이용하여 클래스를 찾는다.
		//Class.forName("패키지명.클래스명")
		//메타정보(Class 객체)를 메모리에 올림
		
		Class clazz = Class.forName(ClassName);
		//객체를 만든다. 
		//getDeclaredConstructor(): 클래스의 선언된 생성자를 가져오는 기능
		//newInstance(): 그 생성자를 통해서 객체를 만든다.
		Object obj = clazz.getDeclaredConstructor().newInstance();
		
		return (Logger) obj;	
		
		}catch(Exception e) {
			throw new RuntimeException("Logger 생성실패: " + e);
		}
		
	}
}