package chapter_07;

import java.io.IOException;
import java.sql.SQLClientInfoException;

public class OverridingPrac {

	public void main(){
		
	}
	
	class Point{
		int x;
		int y;
		
		public String getLocation() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}
	
	class Point3D extends Point {
		int z;

		@Override
		public String getLocation() {
			return "Point3D [" + super.getLocation() + " z=" + z + "]";
		}
	}
}
