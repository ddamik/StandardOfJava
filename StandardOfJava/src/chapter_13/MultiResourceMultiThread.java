package chapter_13;

import javax.swing.JOptionPane;

public class MultiResourceMultiThread {

	public void singleThread(){
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		System.out.println("입력하신 값은 " + input + " 입니다.");
		
		for(int i=10 ; i>0 ; i--){
			System.out.println(i);
			try{
				Thread.sleep(1000);
			}catch(Exception e){}
		}
	}
	
	public void multiThread(){
		ThreadPrac thread = new ThreadPrac();
		thread.start();
		
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		System.out.println("입력하신 값은 " + input + " 입니다.");
	}
	
	class ThreadPrac extends Thread{
		public void run(){
			for(int i=10 ; i>0 ; i--){
				System.out.println(i);
				try{
					sleep(1000);
				}catch(Exception e){}
			}
		}
	}
}
