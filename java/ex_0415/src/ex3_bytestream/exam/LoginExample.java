package ex3_bytestream.exam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class LoginExample {
	public static void main(String[] args) {
		File f = new File("member.txt");
		byte[] members = new byte[(int) f.length()];
     
		Scanner sc= new Scanner(System.in);
	
     try {
		FileInputStream fm = new FileInputStream("member.txt");
	fm.read(members);
	String str= new String(members);
	
	while(true){
	 System.out.println("아이디: ");
     String id = sc.next();
     System.out.println("비밀번호: " );
     int password = sc.nextInt();
       if(id.equals("apple")&&password==1234) {
    	System.out.println("로그인 성공");
    	  break;   
    	 }
     }
     fm.close();
     
     } catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
	}

}
