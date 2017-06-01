package chapter_11.arraylist;

import java.util.Vector;

public class VectorEx1 {

	public void main(){
		
		/**
		 * 	capacity(용량)가 5인 Vector를 생성하고, 3개의 객체를 저장한다.
		 * 	나머지 공간에는 Null값이 채워진다.
		 */
		Vector vector = new Vector(5);
		vector.add("1");
		vector.add("2");
		vector.add("3");
		print(vector);
		
		/**
		 * 	vector.trimToSize()를 호출하면, vector의 빈 공간을 없애서 size와 capacity를 같게 한다.
		 * 	배열의 크기는 변경할 수 없기 때문에 새로운 배열을 생성해서 그 주소값을 변수 vector에 할당한다.
		 * 	기존의 Vector인스턴스는 더 이상 사용할 수 없으며, 나중에 가비지컬렉터에 의해서 메모리에서 제거된다.
		 */
		vector.trimToSize();
		System.out.println("=== After trimToSize() === ");
		print(vector);
		
		/**
		 * 	vector.ensureCapacity(6)는 vector의 capacity가 최소한 6이 되도록 한다.
		 * 	만일 vector의 capacity가 6이상이면 아무일도 일어나지 않는다.
		 * 	현재는 capacity가 3이므로, 크기가 6인 배열을 생성해서 vector의 내용을 복사한다.
		 * 	기존의 인스턴스를 다시 사용하는 것이 아니라, 새로운 인스턴스를 생성한다.
		 * 	빈 공간은 null값으로 채워진다.
		 */
		vector.ensureCapacity(6);
		System.out.println("=== After Ensurecapacity(6) ===");
		print(vector);
	
		/**
		 * 	vector.setSize(7)은 vector의 size가 7이 되도록 한다.
		 * 	capacity가 충분하면 새로 인스턴스를 생성하지 않아도 되지만, 지금은 6이므로, 새로운 인스턴스를 생성한다.
		 * 	Vector는 capacity가 부족할 경우 자동적으로 기존의 크기보다 2배의 크기로 증가된다.
		 * 	4까지 채워져 있으며, 5,6,7 에는 "null"이 채워진다.
		 */
		vector.setSize(7);
		System.out.println("=== After setSize(7) ===");
		print(vector);
		
		/**
		 * 	vector.clear();는 vector의 모든 요소를 삭제한다.
		 */
		vector.clear();
		System.out.println("=== After clear() ===");
		print(vector);
		
	}
	
	public void print(Vector v){
		System.out.println(v);
		System.out.println("size: " + v.size());
		System.out.println("capacity: " +v.capacity());
	}
	
	
	int size = 0;
	Object[] data = null;
	
	public Object vectorRemove(int index){
		Object oldObj = null;
		
		if( index < 0 || index >= size ){
			throw new IndexOutOfBoundsException("범위를 벗어남.");
		}
		
		oldObj = data[index];
		
		//	삭제하고자 하는 객체가 마지막 객체가 아니라면, 배열복사를 통해 빈자리를 채워줘야 한다.
		if( index != size-1 ){
			//	data[index+1] ~ data[size-index-1] 데이터 값을 data[index]부터 복사해서 넣어라.
			System.arraycopy(data, index+1, data, index, size-index-1);
		}
		
		//	마지막 데이터를 null로 한다. 배열은 0부터 시작하므로 마지막 요소는 index가 size-1이다.
		data[size-1] = null;
		size--;
		return oldObj;
	}
}
