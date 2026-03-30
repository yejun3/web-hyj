package ex_2_method;

public class AA {
	public static void main(String[] args) {
		int a=  3;
		int[] arr = new int[a];
		int count=0;		
		for(int i=1; i<arr.length; i++){
					if(i%2==0) { 
					 count++;
					}
			}
	
		System.out.println(count);			 	
	}

}
