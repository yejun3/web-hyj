package test;

public class AverageTest {
	 public static void main(String[] args) {
	       int[] scores = {80, 90, 75, 100};
	       int sum = 0;

	
	       for (int i = 0; i < scores.length; i++) {
	           sum += scores[i];
	       }

	   
	      double average = (double)sum / scores.length;

	      System.out.println("총합: "+ sum);
	       System.out.println("평균 점수: " + average);
	   }

}
