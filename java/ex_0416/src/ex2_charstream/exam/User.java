package ex2_charstream.exam;

import java.io.ObjectInputStream.GetField;

public class User {
	
	private String id;
	private String password;
	
	public User(String id,String password) {
		this.id=id;
		this.password=password;
	}

	public void setId(String id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	
	//바이트배열을 반환
   public byte[] toByteData() {
	  String user = "아이디 : 비밀번호\n";
	  return user.getBytes();

  

   }
}
