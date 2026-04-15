package exam;

import java.util.function.Consumer;

public class Main {
	//Consumer : "T 타입 값을 받아서 처리만 하고 반환은 하지 않는 함수"
   static void executePrint(Consumer<String> action, String message){
     action.accept(message);
   }
    
   public static void main(String[] args) {
	   Print print = new Print();
	   
	   Consumer<String> action = print::print;
	   executePrint(action, "람다식 전달 연습"); 
   }

}
