package ex_3_generic;
// 제네릭 타입은 두개 이상도 작성할 수있다.
class PairBox<T,U>{
	private T first;
	private U second;
	
	public void set(T first,U second) {
		this.first=first;
		this.second=second;
	}
	
	public T getT() {
		return first;
	}
	
	public U getU() {
		return second;
	}
	
}


public class MultiTypeExample {
	public static void main(String[] args) {
		PairBox<String, Integer> box1 = new PairBox<String, Integer>();
		box1.set("홍길동",20);
		System.out.println(box1.getT());
		System.out.println(box1.getU());
		
	
		PairBox<String, Double> box2 = new PairBox<String, Double>();
		box2.set("심철수",20.0);
		System.out.println(box2.getT());
		System.out.println(box2.getU());
	}

}
