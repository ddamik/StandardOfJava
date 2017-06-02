package chapter_07;

public class InheritancePrac {

	public void main(){
		
		Unit unit = new Tank();
		Tank tank = new Tank();
		AirCraft ac = new AirCraft();
		
		tank = (Tank) unit;

		
		
		
	}
	
	class Unit{}
	class AirUnit extends Unit{}
	class AirCraft extends AirUnit{}
	
	class GroundUnit extends Unit{}
	class Tank extends GroundUnit{}
}
