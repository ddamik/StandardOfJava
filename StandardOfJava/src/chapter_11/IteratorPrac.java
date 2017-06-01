package chapter_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class IteratorPrac {

	public void main(){
		List list = new ArrayList<>();
		Iterator it = list.iterator();
		
		while(it.hasNext())						//	hasNext(): 읽어 올 요소가 남아있는지 확인한다.
			System.out.println(it.next());		//	next(): 다음 요소를 읽어온다.
		
	
		Map map = new HashMap<>();
		Iterator iter = map.keySet().iterator();
		
		
		
		//	ListIterator
		list.add("1");
		list.add("2");
		list.add("3");
		
		ListIterator listIter = list.listIterator();
		while(listIter.hasPrevious())
			System.out.println(listIter.previous());
		
		//	ListIterator의 remove경우,
		//	선택적인 기능으로써, { } 와 같은 구현보다는 UnsupportedOperationException 예외를 던져서 구현되지 않은 기능이라 알리는 것이 좋다.
		
	
		 
	}
	 
}
