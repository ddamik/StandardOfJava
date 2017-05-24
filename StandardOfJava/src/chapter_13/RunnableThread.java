package chapter_13;

public class RunnableThread {

	public void chapter13_main(){
		this.runnableThreadPrac();
	}
	
	
	/**
	 * 	Runnable Thread
	 */
	public void runnableThreadPrac(){
		Runnable r = new ThreadPrac();
		Thread thread = new Thread(r);
		thread.start();
	}
	
	
	/**
	 * Thread - Runnable
	 * @author ddamik
	 *
	 */
//	public class Thread{
//		private Runnable r;
//		
//		public Thread(Runnable r){
//			this.r =  r;
//		}
//		
//		public void run(){
//			if( r != null ) r.run();
//		}
//	}
	
	class ThreadPrac implements Runnable {
		public void run(){
			System.out.println(Thread.currentThread().getName());
			throwException();
		}
		
		public void throwException(){
			try{
				throw new Exception();
			} catch ( Exception e ){
				e.printStackTrace();
			}
		}
	}
}
