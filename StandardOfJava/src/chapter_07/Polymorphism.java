package chapter_07;

import java.util.Vector;

public class Polymorphism {

	/**
	 * Up-casting Down-casting
	 */
	class Tv {
		boolean power;
		int channel;

		void power() {
			power = !power;
		}

		void channelUp() {
			++channel;
		}

		void channelDown() {
			--channel;
		}
	}

	/**
	 * 조상클래스의 인스턴스를 자손클래스의 참조변수는 참조할 수 없다.
	 *
	 */
	class CaptionTv extends Tv {
		String text;

		void caption() {
		}
	}

	class Car {
		int c;
	}

	class FireEngine extends Car {
		int f;
	}

	class Ambulance extends Car {
		int a;

		public void water() {
			System.out.println("Water");
		}
	}

	/**
	 * 참조변수와 인스턴스의 연결. 조상클래스의 인스턴스변수와 자손클래스의 인스턴스변수명이 같은 경우, 선언한 타입에 따라 다르다.
	 */
	class Parent {
		int x = 100;
	}

	class Child extends Parent {
		int x = 200;
	}

	
	/**
	 * 	매개변수의 다형성.
	 * 	
	 * 	Buyer클래스는 Product를 구입하는 사람을 클래스로 표현.
	 * 	Buyer클래스에 물건을 구입하는 기능의 메서드를 추가하는데, 구입할 대상이 필요하므로 매개변수로 구입할 제품을 넘겨받아야 한다.
	 */
	
	class Product {
		int price;
		int bonusPoint;
	}
	
	class TvProduct extends Product {}
	class ComputerProduct extends Product {}
	class AudioProduct extends Product {}
	
	class Buyer {
		int money = 1000;
		int bonusPoint = 0;
		Vector item = new Vector();
		
		
		/**
		 * 	매개변수가 Product타입의 참조변수라는 것은, Product클래스의 자손타입의 참조변수면 어느 것이나 매개변수로 받아들일 수 있다.
		 * 	따라서, TvProduct, ComputerProduct, AudioProduct 모두 Product를 상속했기에, buy의 매개변수로 받아들일 수 있다.
		 *  결과적으로, buyTv, buyComputer, buyAudio 등 각각의 제품구매 메서드를 따로 만들 필요가 없다.
		 */
		void buy(Product p){
			if( money < p.price ){
				System.out.println("잔액이 부족합니다.");
				return;
			}
			
			money = money - p.price;
			bonusPoint = bonusPoint + p.bonusPoint;
			item.add(p);
			System.out.println(p + "를 구입하셨습니다.");
		}
	}
	
	public void main() {

		// 조상클래스의 참조변수로, 자손클래스의 인스턴스를 생성.
		// Tv tv = new CaptionTv();

		// 참조변수 ctv가 실제 인스턴스인 Tv의 멤버 개수보다 사용할 수 있는 멤버 개수가 많아서 에러!!
		// CaptionTv ctv = new Tv();

		// Car car = new Car();
		// FireEngine fireEngine = new FireEngine();
		// FireEngine fireEngine2 = null;
		//
		// car = fireEngine; // 자손타입 참조변수를 조상타입 참조변수로 형변환. ( Up-casting, 형변환
		// 생략가능. )
		// fireEngine2 = (FireEngine)car; // 조상타입 참조변수를 자손타입 참조변수로 형변환. (
		// Down-casting, 형변환 생략불가. )

		// Car car = new Car();
		// FireEngine fireEngine = null;
		// fireEngine = (FireEngine) car; // 조상타입의 인스턴스를 자손타입의 참조변수로 참조하는 것은
		// 허용되지 않는다.

		
//		Parent parent = new Parent();
//		Child child = new Child();

		Product[] item = new Product[3];
		item[0] = new TvProduct();
		item[1] = new ComputerProduct();
		item[2] = new AudioProduct();
		
		
		
	}

}
