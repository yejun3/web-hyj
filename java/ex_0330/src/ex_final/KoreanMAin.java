package ex_final;

public class KoreanMAin {
	
	public static void main(String[] args) {
		Korean k1= new Korean("123456-1234567","홍길동");
		Korean k2= new Korean("123456-1457","철수");
		
		System.out.println(k1.nation);
		System.out.println(k1.ssn);
		System.out.println(k1.name);
		
		System.out.println(k2.nation);
		System.out.println(k2.ssn);
		System.out.println(k2.name);
	}
	

}
