package ex2_charstream.exam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example {
	public static void main(String[] args) {
		//test파일에 아무내용이나 적는다.
		//내용을 읽어와서 영어 대문자 소문자 몇개있는지 출력
		FileOutputStream out = null;
		FileInputStream in =null;
		
		try {
			out = new FileOutputStream("test.txt");
			String msg = "adsfsggasQGss";
			out.write(msg.getBytes());
			in = new FileInputStream("test.txt");
			
			int data=0;
			int count1=0;
			int count2=0;
			
			while((data= in.read())!=-1) {
				if(data>='A'&& data<='Z') {
					//if안의 조건식을 적지 못했음
					count1++;
				}else if(data>='a'&& data<='z') {
					count2++;
				}
			}
			System.out.println("대문자 : " + count1);
			System.out.println("소문자: " + count2);
		
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
