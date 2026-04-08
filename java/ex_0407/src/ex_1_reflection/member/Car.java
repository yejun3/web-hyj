package ex_1_reflection.member;

public class Car {
	
	private String model;
	private String owner;
	
	public Car() {
		
	}
	
	public Car(String model) {
		this.model=model;
	}
	
	
	public void setModel(String model) {
		this.model=model;
	}
	public void setOwner(String owner) {
		this.owner=owner;
	}
	public String getModel(String model) {
		return model;
	}
	public String getOwner(String  owner) {
		return  owner;
	}
	
}
