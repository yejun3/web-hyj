package ex_1_List.ArrayList.stack;

import java.util.Stack;

//Stack
//LIFO(LastInFirstOut)
//후입선출구조를 가지는 자료구조 (나중에 들어온 것이 먼저 나간다.)
public class StackExample {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
	
	//스택에 데이터를 추가할때 
    //push()
	stack.push(1);
	stack.push(2);
	stack.push(3);
		
	//stack 들어있는 내용 꺼내기
	//pop();
	System.out.println(stack.pop());// 3이나옴(가장 나중에 넣은 값)
		
	//현재 맨 위에 있는 값
	//peek();
	System.out.println(stack.peek());	
	}

}
