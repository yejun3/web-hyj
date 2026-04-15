package ex1_generic;

public class Annimal {
	public void move(){
		System.out.println("동물이 움직임");
	}

}
class Dog extends Annimal{};
class Cat extends Annimal{};