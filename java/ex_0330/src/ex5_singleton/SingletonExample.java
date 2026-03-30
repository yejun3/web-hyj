package ex5_singleton;

public class SingletonExample {
	public static void main(String[] args) {
		//생성자가 private으로 정의되어 있기 때문에 
		//다른 클래스에서 호출이 불가능
		//Singleton obj = new Singleton();
		
		// Singleton클래스에서 만들어놨던 객체를 받아온 것
		Singleton obj1= Singleton.getInstance();
		Singleton obj2= Singleton.getInstance();
	
	
	//obj1과 obj2가 같은 객체인지 증명하기
	//같은 객체면 "같은 객체입니다."
   // 다른 객체면 "다른 객체입니다."
      if(obj1==obj2) {
    	  System.out.println("같은 객체입니다.");
      }else {
    	  System.out.println("다른 객체입니다.");
      }
		
	
	
	}

}
