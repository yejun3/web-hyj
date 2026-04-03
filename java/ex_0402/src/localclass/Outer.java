package localclass;

//지역내부클래스
//외부클래스의 메서드안에 선언되고 그 메서드 안에서만 사용되는 클래스

public class Outer {
	
	int num= 10;
	
	
	void method() {
		int value=100;
		//지역변수의 경우는 메서드가 끝나면 사라지는 값이다.
		// 지역내부 클래스는 메서드 안에서 정의되었더라도 실제로
	    //나중에 사용될 수도 있다.
		
		// 자바는 안전하게 값을 처리할려고 하기 때문에 
		//지역내부 클래스가 사용하는 지역변수의 값을 복사해서 사용한다.
		//변수값이 바뀌면 "원래 값" "복사된 값"이 달라져서 혼란이 온다.
    // 지역 내부 클래스
	
		class Local{
		void print(){
			System.out.println(num);
			//메서드 안에서 만들어진 지역변수도 사용 할 수있다.
			//지역변수의 값이 바뀌면 안된다.
			System.out.println(value);
		}	
	}

	Local local = new Local();
	
	}	




}
