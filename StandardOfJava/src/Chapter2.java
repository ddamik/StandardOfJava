import javax.swing.plaf.synth.SynthSeparatorUI;

public class Chapter2 {

	public void chapter2Page36() {
		byte b = 1;
		short s = 2;
		char c = 'A';

		int finger = 10;
		long big = 100_000_000_000L;
		long hex = 0xFFFF_FFFF_FFFF_FFFFL; // long hex = 0xFFFFFFFFFFFFFFFFL;

		int octNum = 010; // 8진수 10, 10진수로는 8
		int hexNum = 0x10; // 16진수 10, 10진수로는 16
		int binNum = 0b10; // 2진수 10, 10진수로는 2

		System.out.printf("b=%d%n", b);
		System.out.printf("s=%d%n", s);
		System.out.printf("c=%c, %d %n", c, (int) c);

		System.out.printf("finger=[%5d]%n", finger); // 오른쪽정렬.
		System.out.printf("finger=[%-5d]%n", finger); // 왼쪽정렬.
		System.out.printf("finger=[%05d]%n", finger); // 5칸을 만들고, 빈 칸은 0으로 채운다.

		System.out.printf("big=%d%n", big);
		System.out.printf("hex=%x%n", hex);
		System.out.printf("octNum=%o, %d%n", octNum, octNum);
		System.out.printf("hexNum=%x, %d%n", hexNum, hexNum);

		String url = "Standard procedure of Java";
		System.out.printf("[%s]%n", url); // 문자열의 길이만큼 출력공간을 확보.
		System.out.printf("[%20s]%n", url); // 최소 20글자 출력공간 확보. (오른쪽정렬)
		System.out.printf("[%-20s]%n", url); // 최소 20글자 출력공간 확보. (왼쪽정렬)
		System.out.printf("[%.8s]%n", url); // 왼쪽부터 8글자 출력.

	}

	public void casting() {

		/**
		 * < 정수형을 실수형으로 변환 > 실수형은 정수형보다 훨씬 큰 저장범위를 갖기 때문에, 정수형을 실수형으로 변환하는 것은
		 * 무리가 없다.
		 * 
		 * int형의 최대값은 약 20억으로 최대 10자리의 정밀도를 요구하지만, float는 10진수로 약 7자리의 정밀도만을
		 * 제공하므로, int를 float으로 변환할 때 정밀도 차이에 의해 오차가 발생할 수 있다. 그래서 10진수로 8자리 이상의
		 * 값을 실수형으로 변환할 때는 float가 아닌 double로 형변환해야 오차가 발생하지 않는다.
		 */
		int first = 91234567;

		double doubleCasting = (double) first;
		float floatCasting = (float) first;

		int doubleResult = (int) doubleCasting;
		int floatResult = (int) floatCasting;

		System.out.println();
		System.out.println("First = " + first);
		System.out.println("Float");
		System.out.println("FloatCasting = " + floatCasting);
		System.out.println("FloatResult = " + floatResult);
		System.out.println();
		System.out.println("Double");
		System.out.println("DoubleCasting = " + doubleCasting);
		System.out.println("DoubleResult = " + doubleResult);
		System.out.println();

	}

	public void problem() {

		// 2-2
		System.out.println("\nProblem 2-2");
		double regNo = 9201041234567L;

		// 2-5
		System.out.println("\nProblem 2-5");
		System.out.println("1" + "2"); // 12
		System.out.println(true + ""); // true
		System.out.println('A' + 'B'); // 65 + 66 = 131
		System.out.println('1' + 2); // '1': 49 + 2 = 51
		System.out.println('1' + '2');
		System.out.println('J' + "ava"); // Java
		// System.out.println(true + null);

		// 2-7
		int $ystem = 1;
		int 자바 = 2;
		int $MAX_NUM = 4;

		// 2-9
		byte b = 10;
		char ch = 'A';
		int i = 100;
		long l = 1000L;

		b = (byte) i;
		ch = (char) b;
		short s = (short) ch;
		float f = (float) l;
		i = ch;

		// 2-11
		float ffff = 3.14f;
		double dddd = 1.4e3f;

		// 2-13
		boolean dBoolean = false;
		char dChar = 0;
		float dFloat = 0;
		int dInt = 0;
		long dLong = 0;
		String dString = null;
		
		System.out.println(dBoolean + " / " + dChar + " / " + dFloat + " / " + dInt + " / " + dLong + " / " + dString);
	}
}
