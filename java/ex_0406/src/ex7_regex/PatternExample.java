package ex7_regex;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.regex.Pattern;

public class PatternExample {
	public static void main(String[] args) {
		String regExp = "(02|010)-[0-9]{3,4}-[0-9]{4}";
		// 02 아니면 010 - 0에서9사이의 숫자 3자리 또는 4자리 -  0에서9사이의 숫자 4자리이닞 검증
		
		String data = "010-123-4567";
		boolean result = Pattern.matches(regExp, data);
		
		System.out.println(result);
		
		//주민등록번호 정규식 만들기
		
		regExp = "[0-9]{6}-[0-9]{7}";
		String ssn = "001234-1234567";
		 result = Pattern.matches(regExp, ssn);
		 System.out.println(result);
	
	
		 regExp = "[0-9]{2}(0[1-9]|1[1-2])(0[1-9]|[12][0-9]|3[01])-?[1-4][0-9]{6}";
			String ssa = "001231-1234567";
			 result = Pattern.matches(regExp, ssa);
			 System.out.println(result);
			 
			 String birth = ssn.substring(0,6);
			 int year = Integer.parseInt("20"+birth.substring(0,2));
		      System.out.println("생일 : " + year);
		      int month = Integer.parseInt(birth.substring(2,4));
		      System.out.println("월 : " + month);
		      int day = Integer.parseInt(birth.substring(4,6));
		      System.out.println("일 : " +  day);
		      
		      try {
		         LocalDate.of(year, month,day);
		      } catch (Exception e) {
		         System.out.println("잘못된 날짜");
		      }
		      
		      
		      // 숫자만 입력되었는지 검사
		      //숫자로만 이루어져있는지 검사한느코드
		      // 12345는 통과
		      
		    regExp = "[0-9]+"; //0에서9까지 숫자 중 1나 이상
		  String num = "12345";
		  result = Pattern.matches(regExp, num);
		  System.out.println(result);
		
		  
		//아이디   
		//영어 소문자로시작
		//영어 소문자 숫자만 허용
		//5~12자
		  
		 regExp = "[a-z][a-z0-9]{4,11}";
		//[]안에서는 정규표현식 기호를 쓰려고 해봤자 하나의 문자로 인식이 되서 소용없음
		 String id = "yejun300";
		 result = Pattern.matches(regExp, id);
		  System.out.println(result);
		  
		  System.out.println(id.matches(regExp));
		  
		  //이메일 형식 검사
		  //아이디 부분 : 영문,숫자,_
		  //도메인포함
		  //예시 : test01@gmail.com
		  
		  regExp="[a-zA-Z0-9_]+@(naver|gmail).com";
		String id2 = "test01@gmail.com";
		System.out.println(id2.matches(regExp));
		
		
		String[] arr = {"123","abc","4567","a1b2"};
		regExp = "[0-9]+";
		for(String s: arr) {
			if(s.matches(regExp)) {
				System.out.println(s);
			}
		}
		
		String [] arr2 = {"홍길동","tom","김철수","기이갑조현을"};
		regExp = "[가-힣]{2,5}";
		for(String a: arr2) {
			if(a.matches(regExp)) {
				System.out.println(a);
			}
		}
		
		
		
		
	}

}
