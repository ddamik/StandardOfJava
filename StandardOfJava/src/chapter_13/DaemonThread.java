package chapter_13;

import java.util.Iterator;
import java.util.Map;

public class DaemonThread implements Runnable {

	static boolean autoSave = false;
	
	/**
	 *	데몬 쓰레드는 다른 일반 쓰레드의 작업을 돕는 보조적인 역할을 수행하는 쓰레드이다.
	 *	일반 쓰레드가 모두 종료되면 데몬 쓰레드는 강제적으로 자동 종료되는데, 
		그 이유는 일반 쓰레드의 보조역할을 수행하므로 일반 쓰레드가 모두 종료되고 나면 데몬 쓰레드의 존재의 의미가 없다.
	 *	데몬 쓰레드의 예로는 가비지 컬렉터, 워드프로세서의 자동저장, 화면자동갱신 등이 있다.
	 
	 * 	데몬 쓰레드는 무한루프와 조건문을 이용해서 실행 후 대기하고 있다가 특정 조건이 만족되면 작업을 수행하고 다시 대기하도록 작성한다.
	 *	데몬 쓰레드는 일반 쓰레드의 작성방법과 같으며 다만 쓰레드를 생성한 다음 실행하기 전에 setDaemon(true)를 호출하기만 하면 된다. 
	 * 	데몬 쓰레드가 생성한 쓰레드는 자동적으로 데몬 쓰레드가 된다는 점도 알아두자.
	 */
	
	/**
	 * 	3초마다 변수 autoSave의 값을 확인해서 그 값이 true이면, autoSave()를 호출하는 일을 무한히 반복하도록 쓰레드를 작성했다.
	 */
	public void daemonThread(){
		Thread thread = new Thread(new DaemonThread());
		thread.setDaemon(true);
		thread.start();
		
		for(int i=1; i<=10 ;i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) { }
			
			System.out.println(i);
			
			//	5초 이후부터 자동저장을 시작하겠다.
			if( i == 5 ) autoSave = true;
		}
	}
	
	public void run(){
		while(true){
			try{
				Thread.sleep(3*1000);
			}catch (InterruptedException e) { }
			
			//	3초마다 autoSave를 호출하겠다.
			if( autoSave ) autoSave();
		}
	}
	
	public void autoSave(){
		System.out.println("작업파일이 자동저장되었습니다.");
	}
	
	
	
	
	/**
	 *	getAllStackTraces()를 이용하여 실행 중 또는 대기상태, 즉 작업이 완료되지 않은 모든 쓰레드의 호출스택을 출력.
	 *	프로그램을 실행하면 JVM은 가비지컬렉션, 이벤트처리, 그래픽처리와 같이 프로그램이 실행되는 데 필요한 보조작업을 수행하는 데몬 쓰레드들을 자동으로 생성.
	 *	이 들은 'system쓰레드 그룹' 또는 'main쓰레드 그룹'에 속한다.
	 */
	
	public void checkDeamonThread(){
		ThreadEx11_1 thread1 = new ThreadEx11_1("thread1");
		ThreadEx11_2 thread2 = new ThreadEx11_2("thread2");
		thread1.start();
		thread2.start();
	}
	
	class ThreadEx11_1 extends Thread{
		public ThreadEx11_1(String name) {
			super(name);
		}
		
		public void run() {
			try{
				sleep(5*1000);
			}catch(InterruptedException e){}
		}
	}
	
	class ThreadEx11_2 extends Thread {
		public ThreadEx11_2(String name){
			super(name);
		}
		
		public void run(){
			Map map = getAllStackTraces();
			Iterator it = map.keySet().iterator();
			
			int x=0;
			while(it.hasNext()){
				Object obj = it.next();
				Thread t = (Thread)obj;
				StackTraceElement[] ste = (StackTraceElement[]) (map.get(obj));
				
				System.out.println("[" + ++x + "] name : " + t.getName()
									+ ", group : " + t.getThreadGroup().getName()
									+ ", daemon : " + t.isDaemon());
				
				for(int i=0;i<ste.length; i++){
					System.out.println(ste[i]);
				}
				
				System.out.println();
			}
		}
	}
}
