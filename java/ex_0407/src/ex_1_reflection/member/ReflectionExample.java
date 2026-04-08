package ex_1_reflection.member;

import java.lang.reflect.Constructor;

public class ReflectionExample {
	public static void main(String[] args) {
		Class clazz = Car.class;
		
		
		System.out.println("[생성자정보]");
		
		//getDeclaredConstructors: 모든 생성자(Constructor) 객체를 배열로 반환
		//Constructor: 생성자 정보를 담고있는 클래스
		Constructor[] constructors=
			  clazz.getDeclaredConstructors();
		
	
		//c.getParameterTypes(); :매개변수의 타입을 반환
		for(Constructor c : constructors) {
		System.out.println(c.getName()+"");
	 Class[] parameters = c.getParameterTypes();
	 printParamters(parameters);
	
	}
	}

	private static void printParamters(Class[] parameters) {
		for(int i=0; i<parameters.length; i++) {
			System.out.println(parameters[i].getName());
			System.out.println(",");
		}
		
	}

}
