package exam;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		
		TextService	ts = new TextService();	
		
		String text = "This product is curruently out of stock.";
		
		String result = ts.processText(text, str -> str.toUpperCase());
		
		
		System.out.println(result);
	
	List<User> users = new ArrayList<>();
	users.add(new User("김철수",25,"서울"));
	users.add(new User("박영희",22,"인천"));
	users.add(new User("김민수",17,"부산"));
	users.add(new User("정다니",24,"서울"));
	
	UserService service = new UserService();
	System.out.println("성인 회원");
	
	service.filterUser(users, service.getFilter("adult"));
	System.out.println("---------");
	System.out.println("서울 거주회원");
	service.filterUser(users, service.getFilter("seoul"));
	System.out.println("---------");
	System.out.println("김씨 회원");
	service.filterUser(users, service.getFilter("kim"));
	
	}

}
