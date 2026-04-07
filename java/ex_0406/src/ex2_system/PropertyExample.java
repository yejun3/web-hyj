package ex2_system;

import java.util.Properties;
import java.util.Set;

public class PropertyExample {
	public static void main(String[] args) {
		//운영체제와 사용자 정보 출력
		String userName = System.getProperty("user.name");
		
		String osName = System.getProperty("os.name");
		
		String userHome = System.getProperty("user.Home");
		
		System.out.println(osName);
		System.out.println(userName); 
		System.out.println(userHome);
		
		//System클래스로부터 속성들의 목록을 가져와 변수에 저장
		Properties props = System.getProperties();
		
		//키 : 값, 키 : 값
		
		//속성들에서 key들만 뽑아서 변수에 저장해
		Set keys = props.keySet();
	
	      //반복문 돌리면서 key에 해당하는 value를 가져와서 출력해
	      for(Object objkey : keys) {
	         String key = (String) objkey;
	         String value = System.getProperty(key);
	         System.out.printf("%-40s: %s\n", key, value);
	      }

	}

}
