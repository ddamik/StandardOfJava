package chapter_07;

public class SuperConstructure {

	class Point {
		int x;
		int y;
		
		Point(int x, int y){
			super();	//	Object Constructor
			this.x = x;
			this.y = y;
		}
	}
	
	class Point3D extends Point {
		int z;
		
		Point3D(int x, int y, int z){
			super(x, y);	//	Point Constructor
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}
