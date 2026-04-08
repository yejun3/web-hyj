package ex_3_generic;

class Pair<T,U>{
	private T first;
	private U second;
	
	public Pair(T first,U second) {
		this.first=first;
		this.second=second;
	}
	//first 와 second 출력하는 print 메서드 만들기
	public void print() {
		System.out.println(first+ "," + second);
	}
	


}

class Box<V>{
	private V value;
	
	public void setValue(V value){
		this.value=value;
	}
	public V get() {
		return value;
	}
	
}



public class NestingExample {
	public static void main(String[] args) {
		
		//중첩제네릭
		Box<Pair<String,Integer>>box = new Box<>();
		Pair<String,Integer> pair =new Pair<>("홍길동",23);
		
		box.setValue(pair);
		box.get().print();
	}

}
