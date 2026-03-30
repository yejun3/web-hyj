package ex4_setter_getter;

public class Student {
	private String name;
	private int age;
	// 하나의 하나의 필드만 설정
	public void setName(String name){
		this.name=name;
	}
	public String getName(String name) {
		return name;
	}
	
	public void setAge(int age) {
		if(age>0) {
			this.age = age;
		}else {System.out.println("잘못된 나이입니다.");
	
		}
	}
	
		public int getAge(int age) {
		
		return age;
	}
}
