package interfaceexample;


public class ButtonExample {
	public static void main(String[] args) {
		Button button =new Button();
		class OkListener implements Button.ClickListener{
			@Override
			public void onClick() {
				System.out.println("전원버튼을 누른다.");	
			}
		}
			button.setClickListener(new OkListener());
			button.click();
			
			class CancleListener implements Button.ClickListener{
				@Override
				public void onClick() {
					System.out.println("캔슬 버튼을 누름");
				}	
			}
		
			button.setClickListener(new CancleListener());
			button.click();
	
	
	
	}	
	
}

	
	
