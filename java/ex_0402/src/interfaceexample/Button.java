package interfaceexample;

public class Button {
	//static 붙이지 않아도 자동으로 static 처리가 된다.
	//중첩 interface는 무조건 static이다.(암묵적 static)
	public static interface ClickListener{
		void onClick();// 추상메서드를 만든다.
		
	}
 //필드
 private ClickListener clickListener;
	
 //setter
 public void setClickListener(ClickListener clickListener) {
	 this.clickListener=clickListener;
 }
 
 // 버튼이 클릭됬을때 실행 메서드 click 추가
 //실행내용 ClickListener인터페이스 필드를 이용해 onClick(); 추상메서드 호출
 public void click(){
	 clickListener.onClick();
 }
 
 
}
