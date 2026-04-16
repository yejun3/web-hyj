package ex3_Bufferedstream.exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ex3_Bufferedstream.InputStraeamReaderExample;

public class SearchExample {
	public static void main(String[] args) {
		//사용자로부터 검색할 단어를 입력받고, stroy.txt파일에서
	      //해당 단어가 포함된 줄을 출력하세요
	      
		 try (
			 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		      BufferedReader file = new BufferedReader(new FileReader("story.txt"));
			){
	    System.out.println("검색 단어 : ");
		String str = br.readLine();
		String line;
		while((line = file.readLine())!=null) {
			if(line.contains(str)) {
				System.out.println(line);
			}
		}
		 
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	      //실행 예시
	      //검색어 입력 : 자바
	      //자바는 객체지향 언어이다.
	      //오늘 자바 공부를 했다.
	      
	      //파일은 한줄씩읽는다.
	      
	      //권장 스트림
	      //BufferedReader
		
	}

}
