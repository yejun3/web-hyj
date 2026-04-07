package ex2_system;

public class ExitExample {
	public static void main(String[] args) {
		for(int i=0; i<10; i++) {
			System.out.println(i);
			if(i==5) {
				System.out.println("프로세스 강제종료");
				System.exit(0);
				//exit int값을 매개값으로 필요로한다.
				//종료상태값은 어떤 값을 주더라도 종료되는데 
				//정상 종료일경우 0, 비정상 종료일때는 1또는 -1로 주는 것이 관례
			}
		}
	}

}
