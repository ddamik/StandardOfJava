package problem;

public class Chapter13 {

	public char c;
	public int d;
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
		 
		System.out.println("c = " + c);
		System.out.println("d = " + d);
		char a;
		short b;
		
	
		User user = new User();
		User user2 = new User();
		User user3 = user;
		
		if( user == user2 ) System.out.println("aa");
		else System.out.println("bb");
		
		if( user == user3 ) System.out.println("cc");
	}

	class User {
		
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
