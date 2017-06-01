package chapter_11.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyLinkedList {

	class Node{
		Node next;		//	다음 요소의 주소를 저장.
		Node previous;	//	이전 요소의 주소를 저장.
		Object obj;		//	데이터를 저장.
	}
	
	public void main(){
		
		ArrayList al = new ArrayList(10);
		for(int i=0; i<10; i++) al.add(i+"");
		
		LinkedList ll = new LinkedList(al);
		for(int i=0; i<10; i++) ll.add(5, "X");
		
		al.size();
		ll.remove(1);
		System.out.println(ll);
	}
}
