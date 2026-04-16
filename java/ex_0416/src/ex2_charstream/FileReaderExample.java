package ex2_charstream;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileReaderExample {
	public static void main(String[] args) {
		//char기반의 스트림은 Reader,Write의 자식클래스를 사용
		//기본적으로 2byte를 지원하기 때문에 2byte언어로 구성된 파일도 쉽게 입출력 가능
		
		    // try - with resources
		    //매개변수로 전달된 객체를 자동으로 닫아준다.
		    //close()를 안해도 됨
			try (FileReader fr = new FileReader("text.txt")){
				
			
				int code =0;
				while((code = fr.read())!=-1) {
					System.out.println((char)code);
				}
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();  
		}
	}
}