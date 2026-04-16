package ex2_charstream.exam;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("hellow.txt");
		    fw.write("첫번째 줄 작성합니다.\n");
			fw.write("두번째 줄 작성합니다.");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
