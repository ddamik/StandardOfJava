package chapter_11.linkedlist;

import java.util.Stack;

public class WebStack {

	public static Stack back = new Stack();
	public static Stack forward = new Stack();
	
	public void main(){
		goURL("1. nate");
		goURL("2. yahoo");
		goURL("3. naver");
		goURL("4. daum");
		
		printStatus();
		
		goBack();
		System.out.println("after click back button");
		printStatus();
		
		goBack();
		System.out.println("after click back button");
		printStatus();
		
		
	}
	
	public void printStatus(){
		System.out.println("back: " + back);
		System.out.println("forward: " + forward);
		System.out.println("현재 화면은: " +back.peek() + " 입니다.");
		System.out.println();
	}
	
	public void goURL(String url){
		back.push(url);
		
		//	어느 페이지를 들어갔으면, 앞으로 가기는 비활성화 된다. 따라서, forward Stack를 clear 시킨다.
		if(!forward.empty()) 
			forward.clear();
	}
	
	public void goBack(){
		
		//	첫 페이지가 아니면, 현재 페이지를 back스택에서 pop하여, forward스택으로 push한다.
		if(!back.empty())
			forward.push(back.pop());
	}
	
}
