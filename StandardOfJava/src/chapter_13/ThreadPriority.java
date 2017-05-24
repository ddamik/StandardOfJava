package chapter_13;

public class ThreadPriority {

	public static final int MAX_PRIORITY = 10;
	public static final int MIN_PRIORITY = 1;
	public static final int NORM_PRIORITY = 5;
	
	public void threadPriority(){
		ThreadOne thread1 = new ThreadOne();
		ThreadTwo thread2 = new ThreadTwo();
		
		thread2.setPriority(7);
		System.out.println("Priority of thread1(-) : " + thread1.getPriority());
		System.out.println("Priority of thread2(|) : " + thread2.getPriority());
		
		thread1.start();
		thread2.start();
	}
	
	class ThreadOne extends Thread{
		public void run(){
			for(int i=0; i<300; i++){
				System.out.print("-");
			}
		}
	}
	
	class ThreadTwo extends Thread{
		public void run(){
			for(int i=0; i<300 ; i++){
				System.out.print("|");
				for(int x=0; x<10000000; x++);
			}
		}
	}
}
