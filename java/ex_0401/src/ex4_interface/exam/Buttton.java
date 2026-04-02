package ex4_interface.exam;

public class Buttton {
	private ClickListener listener;
	
	
	 public void set(ClickListener listener ) {
		 this.listener = listener;
	 }
	
	public void click(ClickListener listener) {
		listener.onClick();
	}

}
