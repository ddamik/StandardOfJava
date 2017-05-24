package chapter_13;

public class MultiThread {

	static long multiStartTime = 0;

	/**
	 * 소요시간1: 94 소요시간2: 60
	 */
	public void multiThread() {
		ThreadMulti thread = new ThreadMulti();
		thread.start();

		multiStartTime = System.currentTimeMillis();
		for (int i = 0; i < 500; i++) {
			System.out.printf("%s", new String("-"));
		}

		System.out.printf("소요시간1: " + (System.currentTimeMillis() - multiStartTime));
	}

	class ThreadMulti extends Thread {
		public void run() {
			for (int i = 0; i < 500; i++) {
				System.out.printf("%s", new String("|"));
			}
			System.out.printf("소요시간2: " + (System.currentTimeMillis() - multiStartTime));
		}
	}

	/**
	 * 소요시간1: 67 소요시간2: 85
	 */
	public void singleThread() {
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < 500; i++) {
			System.out.printf("%s", new String("-"));
		}

		System.out.printf("소요시간1: " + (System.currentTimeMillis() - startTime));

		for (int i = 0; i < 500; i++) {
			System.out.printf("%s", new String("|"));
		}

		System.out.printf("소요시간2: " + (System.currentTimeMillis() - startTime));
	}
}
