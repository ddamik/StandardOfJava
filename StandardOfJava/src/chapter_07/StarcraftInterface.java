package chapter_07;

import java.io.IOException;
import java.nio.CharBuffer;

public class StarcraftInterface {

	void repair(Tank t){ }
	void repair(DropShip t){ }
	
	class Unit{
		int hitPoint;
		final int MAX_HP;
		Unit(int hp) {
			MAX_HP = hp;
		}
	}
	
	class GroundUnit extends Unit {
		GroundUnit(int hp){
			super(hp);
		}
	}
	
	class AirUnit extends Unit {
		AirUnit(int hp){
			super(hp);
		}
	}
	
	
	

	/**
	 * 	Repairable 인터페이스로 관계없던 DropShip, Tank유닛을 관계시켜줬다. 어떻게? DropShip, Tank에서 Repairable을 구현했다.
	 *	이 관계로 인해서 SCV는 DropShip과 Tank유닛을 치유할 수 있는 유닛이라고 판단할 수 있다.
	 *	어떻게 판단하느냐? SCV에서 repair메소드의 매개변수로 Repairable을 받는데, 이 Repairable매개변수에는 Repairable를 구현한 클래스가 들어온다.
	 *	즉, Repairable 인터페이스로 관계 맺어진 DropShip, Tank유닛 등만 들어올 수 있다.
	 *	Marine과 같이 Repairable을 구현하지 않은 유닛은 들어올 수 없다.
	 */
	interface Repairable{ }
	
	class DropShip {}
	class Tank extends GroundUnit implements Repairable{
		Tank(int hp) { super(hp); }
		public String toString(){ return "Tank"; }
	}
	
	class SCV extends GroundUnit implements Repairable {

		SCV() {
			super(60);
			hitPoint = MAX_HP;
		}
		
		void repair(Repairable r){
			if( r instanceof Unit ){
				Unit u = (Unit) r;
				while(u.hitPoint != u.MAX_HP) u.hitPoint++;
			}
			System.out.println(r + "의 수리가 끝났습니다.");
		}
	}
	
	public void main(){
		SCV scv = new SCV();
		Tank tank = new Tank(0);
		scv.repair(tank);
	}

	interface Liftable {
		void liftOff();				//	건물 올린다.
		void move(int x, int y);	//	건물	이동한다.
		void stop();				//	건물 정지한다.
		void land();				//	건물 착륙한다.
	}

	/**
	 * 	Liftable 인터페이스를 구현한 클래스 LiftableImpl을 만듬으로써, Barrack, Factory에 각각 Liftable를 구현할 필요가 없다.
	 * 	LiftableImpl 클래스를 Barrack과 Factory에서 선언하여, LiftableImpl의 메서드들을 가져다 사용하면 된다.
	 * @author ddamik
	 *
	 */
	class LiftableImpl implements Liftable{

		@Override
		public void liftOff() { }

		@Override
		public void move(int x, int y) { }

		@Override
		public void stop() { }

		@Override
		public void land() { }
		
	}
	
	class Barrack implements Liftable {
		LiftableImpl impl = new LiftableImpl();
		public void liftOff() { impl.liftOff(); }
		public void move(int x, int y) { impl.move(x, y); }
		public void stop() { impl.stop(); }
		public void land() { impl.land(); }
	}
	
	
	/**
	 * 		## 인스턴스를 직접 생성하지 않고, getInstance() 메서드를 통해 제공받으면,
	 * 		나중에 다른 클래스의 인스턴스로 변경되어도 A클래스의 변경없이 getInstance()만 변경하면 된다는 장점이 잇다.
	 *
	 */
	interface I{
		public abstract void methodB();
	}
	
	class A{
		public void methodA(){
			I i = InstanceManager.getInstance();
			i.methodB();
		} 
	}
	
	public static class InstanceManager {
		public static I getInstance(){
			return new B();
		}
	}
	
	static class B implements I {

		@Override
		public void methodB() {
			// TODO Auto-generated method stub
		}
		
	}
	
}
