package ex1.innerclass.instanceclass;

//1.클래스내부에서만 쓰는 전용 객체 
//- 외부에 공개할 필요가 없는 경우

public class Car {
      
	//2. 강한 결합
	// 두 클래스가 절대 분리되지 않을 때
	
	
	
	//인스턴스 내부클래스
	private class Engine{// Car 클래스에서쓰는 객체의 클래스
    	  void start() {//메서드 실행
    		  System.out.println("엔진시동");
    	  }
      }

	//Engine클래스는 Car내부에서만 씅미
	void run() {// run 메소드를 호출하면 실행됨
		Engine engine =new Engine();
		engine.start();//start 메서드를 호출	
	}
	
	
}
