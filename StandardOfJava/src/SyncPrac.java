import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SyncPrac {

	public void main(){
		byte a = 1;
		short b = 1;
		int c = 1;
		long d = 1;
		
		float e = 1.0f;
		double f = 1.0;
		
		char g = 1;
		boolean h = false;
		
		a = (byte)c;
		b = (short)g;
		
		
	}
	
	public synchronized void calcSum(){}
	
	public void calcSum2(Object mutex){
		synchronized (mutex) {
			
		}
	}
	
	
	private ReentrantLock lock = new ReentrantLock();
	private Condition forCook = lock.newCondition();
	private Condition forCust = lock.newCondition();
	
	
	volatile boolean suspended = false;
	volatile boolean stopped = false;
	
	 

}
