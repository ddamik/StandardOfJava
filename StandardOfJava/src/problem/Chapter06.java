package problem;

public class Chapter06 {

	// [ 6-1 ][ 6-2 ]
	class SutdaCard {
		private int num;
		private boolean isKwang;
		
		public SutdaCard() {
			this(1, true);
		}
		
		public SutdaCard(int num, boolean isKwang) {
			this.num = num;
			this.isKwang = isKwang;
		}
		
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			if( num<1 || num>10 ) return;
			this.num = num;
		}
		public String isKwang() {
			if(isKwang) return "K";
			else return "";
		}
		public void setKwang(boolean isKwang) {
			this.isKwang = isKwang;
		}
		
		public String info(){
			return this.getNum() + this.isKwang();
		}
	}
	
	
	// [ 6-3 ]
	class Student {
		String name;
		int ban;
		int no;
		int kor;
		int eng;
		int math;
		
		
		public Student() {
			super();
		}

		public Student(String name, int ban, int no, int kor, int eng, int math) {
			super();
			this.name = name;
			this.ban = ban;
			this.no = no;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}

		public int getTotal(){
			return this.kor + this.eng + this.math;
		}
		
		public float getAverage(){
			return (int)(this.getTotal() / 3f * 10 + 0.5f) / 10f;
		}
		
		public String info(){
			return this.name + "," + this.ban + "," + this.no + "," + this.kor + "," + this.eng + "," + this.math 
					+ "," + this.getTotal() + "," + this.getAverage();
		}
	}
	
	public void main(){
		
		//	[ 6-1, 6-2 ]
		SutdaCard card1 = new SutdaCard(3, false);
		SutdaCard card2 = new SutdaCard();
		
		System.out.println(card1.info());
		System.out.println(card2.info());
		
		// [ 6-4 ]
		System.out.println("\n [ 6-4 ]");
		Student s = new Student();
		s.name = "홍길동";
		s.ban = 1;
		s.no = 1;
		s.kor = 100;
		s.eng = 60;
		s.math = 76;
		
		System.out.println("이름: " + s.name);
		System.out.println("총점: " + s.getTotal());
		System.out.printf("평균: %.1f", s.getAverage());
		
		
		//	[ 6-5 ]
		System.out.println("\n [ 6-5 ]");
		Student s2 = new Student("홍길동", 1, 1, 100, 60, 76);
	
		System.out.println(s2.info());
	}
}
