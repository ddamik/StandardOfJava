package chapter_13;

public class ThreadGroupPrac {

	public void threadGroup(){
		
		ThreadGroup main = Thread.currentThread().getThreadGroup();
		ThreadGroup group1 = new ThreadGroup("group1");
		ThreadGroup group2 = new ThreadGroup("group2");
		
		//	ThreadGroup ( ThreadGruop parent, String name )
		ThreadGroup subGroup1 = new ThreadGroup(group1, "SubGroup1");
		
		//	쓰레드 그룹 group1의 최대우선순위를 3으로 변경.
		//	쓰레드가 쓰레드 그룹에 추가되기 이전에 작성되야 한다.
		group1.setMaxPriority(3);
		
		Runnable r = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){}
			}
		};
		
		//	Thread ( ThreadGroup target, Runnable r, String name )
		new Thread(group1, r, "thread1").start();
		new Thread(subGroup1, r, "thread2").start();
		new Thread(group2, r, "thread3").start();
		
		System.out.println(">> List of ThreadGroup : " + main.getName()
								+ ", Active ThreadGroup : " + main.activeGroupCount()
								+ ", Active Thread : " + main.activeCount());
		
		//	thread name, priority, parent name
		main.list();
		
		
	}
}
