package ex_1_class;

public class StudentMain {
	public static void main(String[] args) {
		
		Student gildong = new Student();
	
		gildong.name = "홍길동";
		gildong.age = 25;
		gildong.score = 23;

     Student minsu = new Student();

     minsu.name = "민수";
     minsu.age = 41;    
     minsu.score = 98;

     Student yonghee = new Student();

     yonghee.name = "영희";
     yonghee.age = 30;
     yonghee.score = 90;
     

     // 배열에는 같은 타입의 데이터만 넣을 수 있다.
     // 데이터의 타입은 배열 앞에 명시한다.

     Student [] student = {gildong, minsu, yonghee};
     System.out.println(student[0].name);
     // 배열의 들어있는 내용 모두 출력하기
     
     for(int i=0; i<student.length; i++) {
    	 System.out.println("이름: " + student[i].name);
    	 System.out.println("나이: " + student[i].age);
    	 System.out.println("점수: " + student[i].score);
    	 System.out.println("-------");
     }

}
}