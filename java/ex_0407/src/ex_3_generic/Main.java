package ex_3_generic;

public class Main {
	public static void main(String[] args) {
		GenEx<String> gen = new GenEx<String>();
		
		gen.setValue("java");
		System.out.println(gen.getValue());
		
	
		GenEx<Integer> v2 = new GenEx<Integer>();
		v2.setValue(15);
		System.out.println(v2.getValue());
		
		GenEx<Double> v3 = new GenEx<Double>();
		v3.setValue(14.56);
		System.out.println(v3.getValue());
	

	Sample<String> sample = new Sample<String>();
	sample.addElement("This is String",5);
	System.out.println(sample.getElement(5));
	
	Printer p = new Printer();
	
	//타입 추론
	//제네릭 메서드를 호출할 때 전달한 값으로 타입을 자동 판단한다.
	
	p.printValue("안녕하세요");
	p.printValue(100);
	p.printValue(3.14);
	
	//명시적으로 적는 방법
	p.<String>printValue("안녕");
	p.<Integer>printValue(100);
	
	System.out.println(p.getValue("자바"));

	}
}
