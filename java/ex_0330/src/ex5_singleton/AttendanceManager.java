package ex5_singleton;

public class AttendanceManager {
	
	private static AttendanceManager singleton = new AttendanceManager();
	private int count;
	
			private AttendanceManager() {
		count=0;
	}
 public static AttendanceManager getInstsance() {
	 return singleton;
	 
 }
 
 public void addAttendence() {
	 count++;
 }
 public int getAttendence(int count) {
	 return count;
 }
}
