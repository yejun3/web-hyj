package exam2;

import java.io.File;

public class LogExample {
	public static void main(String[] args) {
		//logs 폴더를 나타내는 File객체 만들기
		//폴더가 존재하지 않으면 "logs 폴더가 없습니다.출력하고 종료
		//logs폴더 안의 파일중 확장자가 .log인 파일만 찾기
		//.log파일의 이름과 크기를 바이트 단위로 출력 
		//마지막에 .log파일 개수와 전체 용량 합계를 계산
		
		//출력예시
		//error.log - 1200byte
		//access.log - 3400byte;
		//system.log - 800byte
		//.log 파일 갯수 : 3
		//전체용량 : 5400byte
		
        //  1. logs 폴더를 나타내는 File 객체 생성
        File f = new File("logs");

        //  2. 폴더 존재 여부 확인
        // exists() → 실제 존재 여부
        // isDirectory() → 폴더인지 확인
        if(!f.exists()) {
        	System.out.println("logs 폴더가 없습니다.");
        }
        
        // 3. .log 파일만 필터링
        // listFiles(필터)
        File[] files = f.listFiles();

        // null 체크 (안전 코드)
        if (files == null) {
            System.out.println("파일을 읽을 수 없습니다.");
            return;
        }

        //4. 개수 & 전체 용량 저장 변수
        int count = 0;
        long totalSize = 0;

        // 5. 반복문으로 파일 정보 출력
        for (File file : files) {
        	if(file.isFile() && file.getName().endsWith(".log")) {
        		 System.out.println(file.getName()+" - " + file.length()+"byte");
                 count++;
                 totalSize += file.length();

        	}
        }

        // 6 결과 출력
        System.out.println(".log 파일 갯수 : " + count);
        System.out.println("전체용량 : " + totalSize + "byte");
    }
}
