package ex_2_method;

public class TimeTable {
 
	public void showTable(int a, int b) {
		for(int i=1; i<a; i++) {
			for(int j=1; j<b; j++) {
			System.out.println( i+ "x"+ j + "=" + i*j );
			}
		}
		
	}
	
}
