package genric.exam.exam2;

import java.util.List;

public class AnimalPrint {
	
	public void printAnimal(List<? extends Animal>list){
		for(Object i : list) {
			System.out.println(i);
		}
		
	
		
		
	}

	

}
