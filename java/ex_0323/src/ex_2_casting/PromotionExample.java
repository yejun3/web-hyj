package ex_2_casting;

public class PromotionExample {

	public static void main(String[] args) {
	// 작은 자료형에서 큰 자료형으로 바꾸려고 할 때 
	//자동으로 변환이 된다.
	byte byteValue =10;
    int intValue = byteValue;
    System.out.println("intValue:"+ intValue);
   
    intValue =50;
    long longValue = intValue;
    System.out.println("longValue:" + longValue);
    
    //문자형타입의 자동형 변환
    //문자형 -> 정수형타입 
    char c = 'A';
    int num = c; // 문자형타입 데이터를 정수형 변수에 대입
    System.out.println(num); // 아스키코드값으로 변경되어 나온다. 

}
}
