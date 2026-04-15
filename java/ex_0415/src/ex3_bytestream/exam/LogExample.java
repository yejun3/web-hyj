package ex3_bytestream.exam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LogExample {
	public static void main(String[] args) {

		File f = new File("logs/error.log");
		byte[] read = new byte[(int) f.length()];
	// error.log파일을 읽어서 "ERROR"라는 단어가 몇 번 등장하는지 출력하시오
    try {
		FileInputStream fs = new FileInputStream("logs/error.log");
	                      //logs폴더 안에 있으므로"logs/error.log"로 찾아야함
	
	fs.read(read);
	String str = new String(read);
	
	int count = 0;
	int index= 0;
	 //ERROR 반복 검색
    while ((index = str.indexOf("ERROR", index)) != -1) {
        count++;
        index += "ERROR".length();
    }

    System.out.println("ERROR 개수 : " + count);

    fs.close();
	
	
	System.out.println(count);
    } catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}   
	}
}
