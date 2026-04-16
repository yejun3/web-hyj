package ex2_charstream.exam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileConverter {
	
	public void copy(String source,String target) {
		//new FileInputStream()은 예외 발생 가능
		//그래서 try 안에서 생성해야 함
		FileInputStream in = null;
		FileOutputStream out = null;
		FileOutputStream fs = null;
			try {
				in = new FileInputStream(source);
				out = new FileOutputStream(target);
				fs = new FileOutputStream("log.txt",true);
			byte[] buffer = new byte[1024];
			int length;
			long totalByte=0;
			
			// 파일 복사  
			while((length = in.read(buffer))!=-1){
				out.write(buffer,0,length);
			   //ㄴbuffer 중에서 0부터 시작해서 length만큼  써라
				//write는 1바이트씩
				totalByte+=length;
			}
			
			// 로그 기록
            String logMsg = "복사완료한 파일크기 : " + totalByte + " bytes\n";
            fs.write(logMsg.getBytes());
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					out.close();
					in.close();
					fs.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}		
	}	
}
