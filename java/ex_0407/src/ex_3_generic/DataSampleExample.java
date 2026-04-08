package ex_3_generic;

public class DataSampleExample {
	public static void main(String[] args) {
		//데이터리스트 객체 만들기
		//제네릭 타입에 전달할 수 았는 것은 클래스밖에 안된다.
		DataList<Integer> list = new DataList<>();
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		//list.add("문자열");
		//list.add(3.14);
	
//배열에 들어있는 내용 출력
		
//저장데이터 타입이 Object이므로 		
 /*for(int i= 0; i<list.size(); i++){
	 Object data = list.get(i);
	 if(data instanceof Integer) {
		 System.out.println("정수: " + (int)data);
	 }else if(data instanceof Double) {
		 System.out.println("정수: " + (double)data);
	 }else if(data instanceof String) {
		 System.out.println("문자열: " + (String)data);
	 }
 }*/
	//데이터 출력
	int sum = 0;
	for(int i =0; i<list.size(); i++) {
		sum+= list.get(i);
	}
	System.out.println(sum);
	//실수타입 객체를 만들고 데이터 3개를 넣은 후 출력하기 
	DataList<Double> list2 =  new DataList<>();
	
	list2.add(12.0);
	list2.add(14.0);
	list2.add(16.0);
	
	for(int i=0; i<list2.size(); i++) {
		System.out.println(list2.get(i));
	}
	
	
	
	
	
	
	
	}
	
	
}
