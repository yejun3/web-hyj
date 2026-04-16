package ex3_Bufferedstream;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class InputStraeamReaderExample {
	public static void main(String[] args) {
		//InputStraeamReader
		//JAva입출력에서 바이스스트림을 문자 스트림으로 변환해주는 다리역할
		
		FileInputStream in = null;
		InputStreamReader is = null;
		
	try {
		in = new FileInputStream("text.txt");
	     //InputStreamReader(기반, 인코딩 타입);
			is = new InputStreamReader(in,"UTF-8");
			int read = 0;
			
			while((read = is.read())!= -1) {
				System.out.println((char)read);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if(is != null) {
					is.close();
				}
				if(in != null) {
					in.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
