package ex1_generic.superEX;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	//list<? super Dog> list에서 허용되는 타입
	//List<Dog>,List<Animal>,List<Object>
	//List<Puppy는 안됨>
	
	//<? super T>를 사용하는 이유
	//T 타입을 안전하게 넣기 위해서 사용한다.
	
	public static void addDog(List<? super Dog> list){
		list.add(new Dog());
	//	list.add(new Puppy());// Puppy객체는 Dog로 취급함
	}
	
   
	
	
	public static void main(String[] args) {
		List<Animal> animalList = new ArrayList<Animal>();
		List<Dog>doglist = new ArrayList<Dog>();
		List<Puppy>puppylist = new ArrayList<Puppy>();
	addDog(animalList);
	addDog(doglist);
	
	//addDog(puppylist);// 불가능 Puppy는 Dog자식클래스이기 때문에
	
	// 각 리스트에 들어 있는 객체의 메서드 호출하기
	System.out.println("animalList: ");
	for(Animal i : animalList) {
		i.speak();
	}
	/*
	System.out.println("animalList: ");
	for(Object i : animalList) {
		(Object)i.speak();
	}
	*/
	System.out.println("doglist: ");
	for(Animal j : doglist) {
		j.speak();
	}
	
	
	
	
	}

}
