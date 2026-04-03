package exam1;
/*l 클래스 만들기
필드
- String power "Off"로 초기화하기
Button 인스턴스 내부 클래스
메서드 press()
ㄴ 외부 클래스의 power 값을 "ON"으로 바꾸고 
"전원을 켭니다"를 출력하기
Main에서 RemoteControl 객체를 생성한 뒤, Button객체를 생성하여 press()메서드 호출하기
마지막에 power값도 출력하기

예시
전원을 켭니다
현재 전원 상태 : On
*/

public class RemoteControl {
	String power= "off";
	
	public class Button{
		String power= "ON";
		public void press() {
			System.out.println("전원을 켭니다");
		}
	}

}
