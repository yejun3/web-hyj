package ex3_bytestream.exam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Example {
	public static void main(String[] args) {
		//file.txt를 만들고 아무 내용이나 입력해둔다.
		//FileInputStream을 이용해 내용을 읽어온 뒤 ,
		//뒤집어도 같은 내용인지 아니지를 판별하세요
		//기러기 , 토마토 , 회문
	
	File f = new File("file.txt");
	byte[] read = new byte[(int) f.length()];	
		
	try {
		FileInputStream fis = new FileInputStream("file.txt");
	fis.read(read);
	
	String ori = new String(read);
	String rev = "";
	
	for(int i = ori.length()-1; i>=0; i--) {
		rev+= ori.charAt(i);
	}
	if(ori.equals(rev)) {
		System.out.println(ori + "는 회문수입니다");
	}else {
		System.out.println(ori + "는 회문수가 아닙니다");
	}
	fis.close();
	
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	
		
		
	}

}
