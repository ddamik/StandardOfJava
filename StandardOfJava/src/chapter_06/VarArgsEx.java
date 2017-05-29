package chapter_06;

public class VarArgsEx {

	public void app(){
		String[] strArr = {"100", "200", "300"};
		
		System.out.println(concatenate("",  "100", "200", "300"));
		System.out.println(concatenate("-", strArr));
		System.out.println(concatenate(",", new String[]{"1", "2", "3", "4"}));
		
	}
	
	static String concatenate(String delim, String... args){
		String result = "";
		
		for( String str: args){
			result += str + delim;
		}
		
		return result;
	}
}
