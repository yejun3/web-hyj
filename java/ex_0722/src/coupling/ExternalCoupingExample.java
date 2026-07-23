package coupling;

public class ExternalCoupingExample {
	
	static class ExternalConfig{
		public static final String API_PROTOCAL = "HTTPS/V1.2";
	}
	
	//1. 외부규격(ExternalConfig)이 변경되거나 수정되면 NetworkClient도 통쨰로 고쳐야한다.
	//2. 외부 규격/환경에 직접 의존하므로 . 외부 연결없이 이 모듈만 독립적으로 테스트하기 어려움
	//3. 시스템 외부 환경 변화에 소프트웨어가 쉽세 흔들린다.
	static class NetworkClient{
		public void connect() {
			System.out.println(ExternalConfig.API_PROTOCAL+"통신규격으로 연결합니다.");
		}
	}

}
