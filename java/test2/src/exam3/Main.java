package exam3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		List<Employee> employee = new ArrayList<>();
	    Scanner sc = new Scanner(System.in);
	
	for(int i=0; i<4; i++) {
		System.out.println("이름: ");
		String name = sc.next();
		System.out.println("급여: ");
		int salary = sc.nextInt();
		employee.add(new Employee(name,salary));
	}
	System.out.println("===급여 높은 순===");
	Collections.sort(employee,(a,b)->b.getSalary()-a.getSalary());
	for(Employee e : employee) {
		e.printInfo();
	}
	
	System.out.println("====이름 오름차순====");
	Collections.sort(employee,(a,b)-> a.getName().compareTo(b.getName()));
	for(Employee a : employee) {
		a.printInfo();
	}
	
	sc.close();
	}

}
