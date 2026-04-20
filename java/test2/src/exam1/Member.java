package exam1;

public class Member {

private String id;

private String name;

private int age;



public Member(String id,String name,int age) {

this.id=id;

this.name=name;

this.age=age;

}



public int getAge() {

return age;

}

public String getId() {

return id;

}

public String getName() {

return name;

}



public void printinfo() {

System.out.println("아이디: " + id + ", 이름: "+ name + ", 나이: "+ age);

}



}