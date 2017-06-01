package chapter_11.arraylist;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class ArrayListEx1 {

	public void main(){
		ArrayList list = new ArrayList(10);
		list.add(new Integer(5));
		list.add(new Integer(4));
		list.add(new Integer(3));
		list.add(new Integer(2));
		list.add(new Integer(1));
		list.add(new Integer(2));
		list.add(new Integer(3));
		
		ArrayList list2 = new ArrayList(list.subList(1, 4));
		print(list, list2);
		
		Collections.sort(list);
		Collections.sort(list2);
		print(list, list2);
		
		System.out.println("list.containsAll(list2): " + list.containsAll(list2));
		
		list2.add("A");
		list2.add("B");
		list2.add("C");
		print(list, list2);
		
		list2.set(3, "Aa");
		print(list, list2);
		
		//	list에서 list2와 겹치는 부분을 제외하고 삭제한다.
		System.out.println("list.retainAll(list2): " +list.retainAll(list2));
		print(list, list2);
		
		//	list2에서 list에 포함된 객체들을 삭제한다.
		/**
		 * 	i를 증가시켜가면서 삭제하면, 한 요소가 삭제될 때마다 빈 공간을 채워야 한다.
		 * 	그렇기 때문에 자리이동이 필요하고, 올바른 결과를 얻을 수 없다.
		 * 	따라서, 제어변수를 감소시켜가면서 삭제를 해야 자리이동이 발생해도 영향을 받지 않고 작업이 가능하다.
		 */
		for(int i=list2.size()-1; i>=0; i--){
			if(list.contains(list2.get(i))) list2.remove(i);
		}
	}
	
	public void print(ArrayList list, ArrayList list2){
		System.out.println("list: " + list);
		System.out.println("list2: " + list2);
		System.out.println();
	}
}
