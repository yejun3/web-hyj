package ex1.innerclass.hiddenclass;

public class Button {
	
	// 중첩 interface는 무조건 static
	public static interface ClickListener{
		void onClick();	
	}

	
	ClickListener clickListener;
	//setter
	public void set(ClickListener clickListener) {
		 this.clickListener=clickListener;
		 }
	//void click();
	//전달받은 객체가 가지는 onClick()매서드 호출하기
	public void click(){
		 clickListener.onClick();
	 }
	
	
}
