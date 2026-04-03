package ex2.object;

public class Student {
	private int no;
	private String name;
	
	public Student(int no, String name) {
		this.no=no;
		this.name=name;
	}
	
	public int getNo() { return no; }
	public String getName() { return name; }

	
//object클래스의 hashcode()메서드를 오버라이딩
	//학생 번호와 이름 해시코드를 합한 새로운 해시코드를 반환
  @Override 
  public int hashCode() {
	  int hashCode = no + hashCode();
	  return hashCode;
  }
  
 //Object의 equals() 메소드를 재정의해서 Student 객체인지를 확인
  @Override
	public boolean equals(Object obj) {
		if(obj instanceof Student target) {
			if(no == target.getNo() && name.equals(target.getName())) {
				return true;
			}
		}
		return false;
	}
}
