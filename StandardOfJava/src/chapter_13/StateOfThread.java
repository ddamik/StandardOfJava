package chapter_13;

import javax.swing.JOptionPane;

import org.omg.CORBA.FREE_MEM;

public class StateOfThread {

	/**
	 * 	sleep(long millis): 일정시간동안 쓰레드를 멈추게 한다.
	 * 	sleep(long millis, int nanos): 0.0015초를 멈추게 하려면 Thread.sleep(1, 500000);
	 * 	sleep의 경우 try-catch문으로 예외처리를 해줘야하기 때문에 아래와 같은 메서드를 만들기도 한다.
	 */
	public void delay(long millis){
		try{
			Thread.sleep(millis);
		}catch(InterruptedException e){}
	}
	
	
	
	/**
	 * 	interrupt() - 쓰레드의 작업을 취소한다.
	 * 	interrupted - 쓰레드가 interrupt 호출되었는지 알려줌. 
	 * 		호출 되었으면 - true
	 * 		호출 안되었으면 - false
	 * 
	 * 	- 쓰레드가 sleep(), wait(), join()에 의해 ‘일시정지 상태’에 있을 때, 해당 쓰레드에 대해 interrupt()를 호출하면, 
	 * 		sleep(), wait(), join()에서 InterruptedException이 발생하고, 쓰레드는 ‘실행대기 상태’로 바뀐다.
	 *	- 즉 멈춰있던 쓰레드를 깨워서 실행가능한 상태로 만드는 것이다.
			1. thread.interrupt();
			2. Thread.sleep(); —> InterruptedExcpetion 발생. 왜냐? 위에서 내가 thread.interrupt()를 호출했으니까
			3. 따라서, thread.interrupt()는 InterruptedException에 의해 멈춰있는 상태에서 실행대기 상태로 변한다.
	 */
	public void interruptPrac(){
		InterruptThread thread = new InterruptThread();
		thread.start();
		
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		System.out.println("입력하신 값은 " + input + " 입니다.");
		thread.interrupt();
		System.out.println("isInterrupted(): " + thread.isInterrupted());
	}
	
	class InterruptThread extends Thread {
		public void run(){
			int i=10;
			while(i!=0 && !isInterrupted()){
				System.out.println(i--);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
				interrupt();
				}
			}
			System.out.println("카운트가 종료되었습니다.");
		}
	}
	
	
	
	/**
	 *	yield() - 다른 쓰레드에게 양보한다.
	 * 	yield()가 호출되면 다시 실행대기상태가 된다.
	 * 	yield()와 interrupt()를 적절히 사용하면, 프로그램의 응답성을 높이고 보다 효율적인 실행이 가능하다.
	 */
	
	class ThreadYield implements Runnable {
		boolean suspended = false;
		boolean stopped = false;
		
		Thread thread;
		
		public ThreadYield(String name) {
			thread = new Thread(this, name);
		}
		
		public void run(){
			String name = thread.getName();
			
			while(!stopped){
				if(!suspended){
					System.out.println(name);
					try{
						Thread.sleep(1000);
					}catch(InterruptedException e){
						System.out.println(name + " - interrupted");
					}
				}else{
					/**
					 * 	suspended가 true라면, 즉 잠시 실행을 멈추게 한 상태라면,
					 * 	쓰레드는 주어진 실행시간을 그저 while문을 의미없이 돌면서 시간낭비할 것이다.
					 * 	이런 상황을 '바쁜 대기상태(busy-waiting)'이라고 한다.
					 *  	
					 *  이 상황에서 while문 안에서 시간낭비하지 않고 다른 쓰레드에게 양보하게 되므로 더 효율적이다.
					 */
					thread.yield();
				}
			}
		}
		
		
		/**
		 * 	suspend와 stop에서 thread.interrupt()를 추가했다.
		 * 	stop()이 호출 되었을 때 Thread.sleep(1000)에 의해 쓰레드가 일시정지 상태에 머물러 있는 상황이라면,
		 * 		stopped의 값이 true로 바뀌었어도 쓰레드가 정지될 때까지 최대 1초의 시간지연이 생길 것이다.
		 * 
		 * 	그러나, 이 상황에서 interrupt()를 호출하면, sleep()에서 InterruptedException이 발생하여	
		 * 		즉시 일시정지 상태에서 벗어나게 되므로 응답성이 좋아진다.
		 * 
		 */
		public void suspend(){
			suspended = true;
			thread.interrupt();	//	다시 대기상태로 만든다.
			System.out.println(thread.getName() + " - interrupt() by suspend()");
		}
		
		public void resume(){
			suspended = false;
		}
		
		public void stop(){
			stopped = true;
			thread.interrupt();
			System.out.println(thread.getName() + " - interrupt() by stop()");
		}
		
		public void start(){
			thread.start();
		}
	}
	
	
	
	/**
	 * 	join: 자신이 하던 작업을 잠시 멈추고 다른 쓰레드의 작업을 참여시킨다.
	 * 	시간을 지정하지 않으면, 해당 쓰레드가 작업을 모두 마칠 때까지 기다리게 된다.
	 * 	sleep()처럼 interrupt()에 의해 대기상태에서 벗어날 수 있다.
	 * 	try-catch문으로 감싸야 한다.
	 */
	static long startTime = 0;
	
	public void ThreadJoinPrac(){
		ThreadJoin thread1 = new ThreadJoin();
		ThreadJoin2 thread2 = new ThreadJoin2();
		
		thread1.start();
		thread2.start();
		startTime = System.currentTimeMillis();
		
		try{
			thread1.join();	//	main 쓰레드가 thread1의 작업이 끝날때까지 기다린다.
			thread2.join();	//	main 쓰레드가 thread2의 작업이 끝날때가지 기다린다.
		} catch(InterruptedException e) {}
		
		System.out.println("소요시간: " + (System.currentTimeMillis() - this.startTime));
	}
	
	class ThreadJoin extends Thread {
		public void run(){
			for(int i=0; i<300; i++){
				System.out.print(new String("-"));
			}
		}
	}
	
	class ThreadJoin2 extends Thread {
		public void run(){
			for(int i=0; i<300; i++){
				System.out.print(new String("|"));
			}
		}
	}
	 
	
	/**
	 * 	join()으로 garbage collector 흉내내기.
	 *	필요한 메모리가 사용할 수 있는 양보다 크거나 전체 메모리의 60%이상을 사용했을 경우 gc를 깨운다.
	 *
	 *	Grabage Collector Thread는 Thread.sleep(10 * 1000)을 통해 10초마다 실행된다.
	 *	남은 메모리가 전체의 40%인 경우에는 interrup()를 호출해서, 즉시 가비지 컬렉터 쓰레드를 깨워 gc()를 수행하도록 했다.
	 *
	 *	join()을 이용해서 쓰레드 gc가 작업할 시간을 어느 정도 확보해주고, main쓰레드가 기다리도록 해서, 사용할 수 있는 메모리를 확보했다.
	 *		이렇게 되면, gc가 작업하는 동안 main쓰레드는 기다리게 되므로, 값이 1000이 넘질 않는다.
	 */
	public void threadGCPrac(){
		ThreadGC gc = new ThreadGC();
		gc.setDaemon(true);
		gc.start();
		
		int requireMemory = 0;
		
		for(int i=0; i<20; i++){
			requireMemory = (int) ( Math.random() * 10 ) * 20;
			
			//	필요한 메모리가 사용할 수 있는 양보다 크거나 전체 메모리의 60%이상을 사용했을 경우 gc를 깨운다.
			if( gc.freeMemory() < requireMemory || gc.freeMemory() < gc.totalMemory() * 0.4 ){
				gc.interrupt();
				try{
					gc.join(100);
				}catch(InterruptedException e){}
			}
		
			gc.usedMemory += requireMemory;
			System.out.println("usedMemory: " + gc.usedMemory);
			
		}
	}
	
	class ThreadGC extends Thread {
		final static int MAX_MEMORY = 1000;
		int usedMemory = 0;
		
		public void run(){
			while(true){
				try{
					Thread.sleep(10*1000);
				}catch(InterruptedException e){
					System.out.println("Awaken by interrupt().");
				}
				
				gc();	//	garbage collector 수행.
				System.out.println("Garbage Collected. Free Memory : " + freeMemory());
			}
		}	//	run
		
		public void gc(){
			usedMemory -= 300;
			if( usedMemory < 0 ) usedMemory = 0;
		}
		
		public int totalMemory() { return MAX_MEMORY; }
		public int freeMemory() { return MAX_MEMORY - usedMemory; }
	}
}
