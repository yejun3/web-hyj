package com.example.demo.di2;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

class Car{};
class SportCar extends Car{};
class Truck extends Car{};
class Engine{}; 

//ApplicationContext
// Spring이 객체를 저장하는 창고(객체 컨테이너)

class AppContext{
	Map map; //객체를 저장할 map을 선언 
	
	//AppContent 객체가 만들어질 떄 HashMap이 만들어진다.
	public AppContext() {
		
		try {
			Properties p = new Properties();
			p.load(new FileReader("config.text"));
			
			//Properties에 저장된 내용을 Map에 저장한채로 시작
			// p는 클래스를 저장한 "config.text"
			map = new HashMap(p);
			for(Object key : map.keySet()) {
				Class clazz = Class.forName((String)map.get(key));
				map.put(key, clazz.newInstance());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		//map에 아예 객체를 저장
//		map.put("car", new SportCar());
//		map.put("engine", new Engine());
	}
	
	Object getBean(String key) {
		return map.get(key);
		//getbean은 만들고 저장해둔 객체를 외부에 꺼내쓰기 위한 함수
	}
	
	
}

public class Main2 {
	public static void main(String[] args) {
		AppContext ac = new AppContext();
		
		Car car = (Car)ac.getBean("car");
		Engine engine = (Engine)ac.getBean("engine");
		
	}

}
