package chapter_07;

import javax.lang.model.type.UnionType;

import chapter_07.InterfacePrac.Unit;

public class InterfacePrac {

	interface interfaceNmae {
		public static final int MAX = 100;

		public abstract void methodNmae();
	}

	class Unit {
		int currnetHP;
		int x;
		int y;
	}

	class Fighter extends Unit implements Fightable {

		@Override
		public void move(int x, int y) {
			// TODO Auto-generated method stub

		}

		@Override
		public void attack(Unit u) {
			// TODO Auto-generated method stub

		}
	}

	interface Fightable extends Moveable, Attackable {
	}

	interface Moveable {
		void move(int x, int y);
	}

	interface Attackable {
		void attack(Unit u);
	}

	public void main() {

		Fightable f = (Fightable) new Fighter();
		Fightable fightable = new Fightable() {

			@Override
			public void attack(Unit u) {
				// TODO Auto-generated method stub

			}

			@Override
			public void move(int x, int y) {
				// TODO Auto-generated method stub

			}
		};
	}

	Fightable attack(Fightable f) {
		// ...
		return f;
	}
}
