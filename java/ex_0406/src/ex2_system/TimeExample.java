package ex2_system;

public class TimeExample {
	public static void main(String[] args) {
		
		//1970년 1월 1일 0시 0분 0초 부터  현재까지 흐른 시간을 밀리초 단위로 반환
		long time = System.currentTimeMillis();
		System.out.println(time);
		
		
		long time1 = System.nanoTime();
		long start = System.currentTimeMillis();
		
		
		//작업
		for(int i = 0; i< 10000000; i++) {};
		
		long end = System.currentTimeMillis();
	
		System.out.println("걸린시간(ms): " + (end-start));
	
	
	
	
	}

}
