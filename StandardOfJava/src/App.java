import chapter_13.DaemonThread;
import chapter_13.MultiResourceMultiThread;
import chapter_13.RunnableThread;
import chapter_13.ThreadGroupPrac;
import chapter_13.ThreadPriority;

public class App {

	public static void main(String[] args){
	
//		RunnableThread chapter13 = new RunnableThread();
//		chapter13.chapter13_main();
		
//		MultiResourceMultiThread msmt = new MultiResourceMultiThread();
//		msmt.singleThread();
//		msmt.multiThread();
		
//		ThreadPriority tp = new ThreadPriority();
//		tp.threadPriority();
		
//		ThreadGroupPrac threadGruop = new ThreadGroupPrac();
//		threadGruop.threadGroup();
		
		DaemonThread daemonThread = new DaemonThread();
//		daemonThread.daemonThread();
		daemonThread.checkDeamonThread();
	}
}
