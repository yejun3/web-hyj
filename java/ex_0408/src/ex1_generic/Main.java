package ex1_generic;

public class Main {
	public static void main(String[] args) {
		//제네릭에 타입을 넣을 수 있는 것은 좋은데 
		//아무타입이나 넣어도 된다는 것도 문제
	Calculator<Number>cal1 = new Calculator<>();
	Calculator<Integer>cal2 = new Calculator<>();
	//Calculator<String>cal3 = new Calculator<>(); ->안됨
	Calculator<Double>cal4 = new Calculator<>();
	
	
	//어떤 기능을 만들 때는 
	//특정 성질을 가진 타입만 받아야 안전하다.
	
	//제네릭에 넣을 수있는 타입의 범위를 한정
	
	//1.잘못된 타입을 미리 막을 수 있다.
	//2.하위 타입의 기능을 사용할 수 있다.
	
	AnnimalHospital<Dog> doghospital = new AnnimalHospital<>(new Dog());
	AnnimalHospital<Cat> cathospital = new AnnimalHospital<>(new Cat());
	
	doghospital.treat();
	cathospital.treat();
	
	//동물병원은 동물만 다루는 곳인데 
	//문자열이나 숫자 다른 객체가 들어오면 이상해진다.
	
	
	DeviceManager<Tv> tvManager = new DeviceManager<Tv>(new Tv());
	DeviceManager<Audio>audioManager = new DeviceManager<Audio>(new Audio());
	
	tvManager.powerOn();
	audioManager.powerOn();
	
	//Readable과 Closeable을 동시에 구현한 클래스만이 타입 할당이 가능하다.
	Box<BoxType>box = new Box<>();
	//Box<Object>box2 = new Box<>();-> 안됨
	}
	

}
