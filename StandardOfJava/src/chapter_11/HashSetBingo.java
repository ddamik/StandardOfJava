package chapter_11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetBingo {

	public void main(){
		Set set = new HashSet<>();
		int[][] board = new int[5][5];
		
		for(int i=0; set.size()<25; i++){
			set.add((int)(Math.random() * 50) + 1 + "");
		}
		
		Iterator it = set.iterator();
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[i].length; j++){
				System.out.println(it.next().hashCode() + " ");
			}
			System.out.println();
		}
	}
}
