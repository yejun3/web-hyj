package ex4_setter_getter;

public class User {
	
private String userName;
private String password;
private String email;

public void setName(String name) {
	if(name.length()>=4) {
		this.userName = userName;
	}else { 
		System.out.println("아이디는 4글자 이상이어야만 합니다.");			
	}
}

public void setpassword(String password) {
	if(password.length()>=6) {
		this.password = password;
	}else {
		System.out.println("페스워드는 6글자이상이어야한다");
	}
 }
public void setemail(String email){
	if(email.contains(("@")){
		this.email = email;
	}else {
		System.out.println("이메일은 @가 있어야 한다");
	}
	
	public void userinfo
	System.out.println();
	
}
			
	
}
