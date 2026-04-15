package ex_1_reflection.log;
//로그 출력 방식을 설정 파일로 바꾸는 시스템 만들기
// 1.로그 출력기능을 가진 인터페이스를 만든다.
//출력방식은 3가지가 있다.
//콘솔 출력 [console] 로그 출력 : 에러 메서지
//파일 출력 [file] 로그 출력 : 에러 메서지
//DB출력 (콘솔로 흉내)

//2.어떤 로그 출력방식을 사용할 지는 config.properties파일에서 결정
//설정 파일 (config.properties)
//정의: 프로그램 실행 시 어떤 출력 방식을 사용할지 지정하는 외부 파일.

//3.프로그램은 설정파일을 읽어서 생성된 객체를 이용해 로그 출력

public interface Logger {
	void log(String message);
}
