package problem;

public class Chapter13 {

	public boolean stopped = false;
	public void main()  {
		// 13-5
		// Thread3 thread = new Thread3();
		// thread.setDaemon(true);
		// thread.start();
		//
		// try {
		// Thread.sleep(5*1000);
		// } catch (Exception e) { }
		//
		// throw new Exception("꽝~!!!");

		
		//	13-5
		// Thread5 thread = new Thread5();
		// thread.start();
		//
		// try {
		// Thread.sleep(6*1000);
		// } catch (InterruptedException e) { }
		//
		// stopped = true;
		// thread.interrupt();
		// System.out.println("Stopped");
		
		int a,b;
		char c;
		
		
	}

	class Thread3 extends Thread {
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println(i);

				try {
					Thread.sleep(3*1000);
				} catch (Exception e) {
				}
			}
		}
	}
	
	class Thread5 extends Thread {
		public void run(){
			for(int i=0; !stopped; i++){
				System.out.println(i);
				try {
					Thread.sleep(3*1000);
				} catch (InterruptedException e) { }
			}
		}
	}
}
