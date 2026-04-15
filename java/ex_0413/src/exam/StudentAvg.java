package exam;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StudentAvg {
	public static void main(String[] args) {
		//이름을 key, 점수를 value로 저장
		//평균 최고점 학생찾기
		String name;
		int score;
		HashMap<String, Integer> students = new HashMap<String, Integer>();
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.print("이름(그만 받고 싶으면 x 입력) : ");
			name = sc.next();
			
			if (name.equals("x")) {
				System.out.println("학생 입력 종료");
				break;
			}
			
			System.out.print("시험 점수 : ");
			score = sc.nextInt();
			
			students.put(name, score);
			
			System.out.println("입력 완료!");

		}
		
Set<Map.Entry<String,Integer>> studentSet = students.entrySet();
		
		int maxScore = 0;
		String maxScoreStudent = "";
		int total = 0;
		
		
		for (Map.Entry<String, Integer> student : studentSet) {
			
			score = student.getValue();
			total += score;
			
			if (maxScore <= score) {
				maxScore = score;
				maxScoreStudent = student.getKey();
			}
			
		}
		
		double average = total / (double)students.size();
		
		System.out.println("평균 점수 : " + average + "점");
		System.out.println("최고 점수 학생 : " + maxScoreStudent + "/" + maxScore + "점");
	}
}