package chapter_06;

public class Chapter06 {

	public void app(){
//		TvTest2();
//		TvTest3();
//		TvTest4();
//		cardTest();
		
//		MyMath mm = new MyMath();
//		mm.tip();
		
		VarArgsEx var = new VarArgsEx();
		var.app();
	}

	//	인스턴스 생성.
	public void TvTest2(){
		Tv t1 = new Tv();
		Tv t2 = new Tv();
		System.out.println("t1의 channel값은 " + t1.channel + "입니다.");
		System.out.println("t2의 channel값은 " + t2.channel + "입니다.");
		
		t1.channel = 7;
		System.out.println("t1의 channel값 " + t1.channel + "로 변경하였습니다.");
		
		System.out.println("t1의 channel값은 " + t1.channel + "입니다.");
		System.out.println("t2의 channel값은 " + t2.channel + "입니다.");
	}
	
	//	참조변수 예제.
	public void TvTest3(){

		Tv t1 = new Tv();
		Tv t2 = new Tv();
		System.out.println("t1의 channel값은 " + t1.channel + "입니다.");
		System.out.println("t2의 channel값은 " + t2.channel + "입니다.");
		
		t2 = t1;
		t1.channel = 7;
		System.out.println("t1의 channel값 " + t1.channel + "로 변경하였습니다.");
		
		System.out.println("t1의 channel값은 " + t1.channel + "입니다.");
		System.out.println("t2의 channel값은 " + t2.channel + "입니다.");
	}

	//	객체 배열.
	public void TvTest4(){
		Tv[] tvArr = new Tv[3];	//	길이가 3인 Tv 객체 배열.
		
		//	Tv객체를 생성해서 Tv객체 배열의 각 요소에 저장.
		for(int i=0; i<tvArr.length; i ++){
			tvArr[i] = new Tv();
			tvArr[i].channel = i+10;
		}
		
		for(int i=0; i<tvArr.length; i++){
			tvArr[i].channelUp();
			System.out.printf("tvArr[%d].channel = %d%n", i, tvArr[i].channel);
		}
	}
	
	public void cardTest(){
		
		System.out.println("Card.width = " + Card.width);		//	클래스변수(static변수)는 객체생성 없이
		System.out.println("Card.height = " + Card.height);		//	'클래스이름.클래스변수'로 직접 사용 가능하다.
		
		Card c1 = new Card();
		c1.kind = "Heart";				//	인스턴스변수의 값을 변경한다.
		c1.number = 7;
		
		Card c2 = new Card();
		c2.kind = "Spade";
		c2.number = 4;
		
		System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며, 크기는 (" + c1.width +", " + c1.height +")");
		System.out.println("c2은 " + c2.kind + ", " + c2.number + "이며, 크기는 (" + c2.width +", " + c2.height +")");
		System.out.println("c1의 width와 height를 각각 50, 80으로 변경합니다.");
		
		c1.width = 50;					//	클래스변수의 값을 변경한다.
		c2.height = 80;					//	클래스변수를 사용할 경우 인스턴스변수말고 클래스이름을 사용하는게 좋으며, 인스턴스변수와 혼동이 없다.
		
		System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며, 크기는 (" + c1.width +", " + c1.height +")");
		System.out.println("c2은 " + c2.kind + ", " + c2.number + "이며, 크기는 (" + c2.width +", " + c2.height +")");
		 
	}

	float divide(int x, int y){
		//	작업을 하기 전에 나누는 수(y)가 0인지 확인한다.
		if(y==0){
			System.out.println("0으로 나눌 수 없습니다.");
			return 0;	//	매개변수가 유효하지 않으므로 메서드를 종료한다.
		}
		return x / (float)y;
	}
}
