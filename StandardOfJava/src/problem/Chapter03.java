package problem;

public class Chapter03 {

	public void main() {
		// num01();
		// num02();
		// num03();
		// num04();
		// num05();
		// num06();
		// num07();
		// num08();
		num09();
		num10();
	}

	public void num01() {
		int x = 2;
		int y = 5;
		char c = 'A'; // 'A'의 문자코드는 65
		System.out.println(1 + x << 33);
		System.out.println(y >= 5 || x < 0 && x > 2);
		System.out.println(y += 10 - x++);
		System.out.println(x += 2);
		System.out.println(!('A' <= c && c <= 'Z'));
		System.out.println('C' - c);
		System.out.println('5' - '0');
		System.out.println(c + 1);
		System.out.println(++c);
		System.out.println(c++);
		System.out.println(c);
	}

	public void num02() {
		int numOfApples = 123;
		int sizeOfBuckets = 10;
		int numOfBucket = numOfApples / sizeOfBuckets + (numOfApples % sizeOfBuckets > 0 ? 1 : 0);

		System.out.println(numOfBucket);
	}

	public void num03() {
		int num = 10;
		System.out.println(num > 0 ? "양수" : num == 0 ? "0" : "음수");
	}

	public void num04() {
		int num = 456;
		System.out.println((num / 100) * 100);
	}

	public void num05() {
		int num = 333;
		System.out.println((num / 10) * 10 + 1);
	}

	public void num06() {
		int num = 81;
		System.out.println((num / 10 + 1) * 10 - num);
	}

	public void num07() {
		int fahrenheit = 100;
		float celcius = (int) ((5 / (float) 9 * (fahrenheit - 32)) * 100 + 0.5f) / (float) 100;

		System.out.println("Fahrenheit:" + fahrenheit);
		System.out.println("Celcius:" + celcius);
	}

	public void num08() {
		byte a = 10;
		byte b = 20;
		byte c = (byte) (a + b);

		char ch = 'A';
		ch = (char) (ch + 2);

		float f = 3 / (float) 2;

		long l = 3000L * 3000L * 3000L;

		float f2 = 0.1f;
		double d = 0.1;
		boolean result = (float) d == f2;

		System.out.println("c=" + c);
		System.out.println("ch=" + ch);
		System.out.println("f=" + f);
		System.out.println("l=" + l);
		System.out.println("result=" + result);
	}

	public void num09() {

	}
	
	public void num10(){
		
	}
}
