package ex1.bytestream;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyExample {
	public static void main(String[] args) {
		//상대경로에있는 이미지 파일을 바이트기반 스트림으로 읽어오기
		//복사본 만들기 복사본 이름 : Wall_copy.jpg
		//복사하면서 걸리는 시간을 currentTimeMillis();로 측정하기

		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream("wall.jpg");
			out = new FileOutputStream("Wall_copy.jpg");
			byte[] buffer = new byte[512];
			//버퍼방식이 굉장히 빠름
			
			long start = System.currentTimeMillis();
			System.out.println("이미지 읽기 시작");
			int data =0;
			//파일을 읽어와서
			while((data = in.read())!=-1) {
				//바로 작성하기
			out.write(data);
			}
			//파일은 4mb
			//우리가 전달한 배열은 512byte
			//우리가 전달한 파일은 바이트씩 잘라서 여러번 읽고 쓰는 방식
			
			
			
			System.out.println("이미지 읽기 종료");
		    long end = System.currentTimeMillis();
		    long time = (end-start)/1000;
		    System.out.println(time+"초");
		
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				//닫을때는 역순으로 닫는다.
				out.close();
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
