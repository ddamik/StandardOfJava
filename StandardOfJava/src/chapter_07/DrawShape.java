package chapter_07;

public class DrawShape {

	public void main(){
		Circle circle = new Circle(new Point(150, 150), 50);
		circle.draw();
	}
}

class Shape{
	String color = "black";
	void draw(){
		System.out.printf(" [ color = %s ] %n", color);
	}
}

class Point {
	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

class Circle extends Shape {
	Point center;
	int r;
	
	Circle(){
		this(new Point(0,0), 100);
	}
	
	Circle(Point center, int r){
		this.center = center;
		this.r = r;
	}
	
	//	overriding
	public void draw(){
		System.out.printf("[ center = (%d, %d), r=%d, color=%s ]%n", center.x, center.y, r, color);
	}
}





