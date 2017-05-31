package chapter_07;

public class ParserTest {
	public Parseable getParser(String type){
		if(type.equals("XML")) return new XMLParser();
		else{
			Parseable p = new HTMLParser();
			return p;
		}
	}
	
	interface Parseable {
		//	구문 분석 작업을 수행한다.
		public abstract void parse(String fileName); 
	}
	
	class XMLParser implements Parseable {

		@Override
		public void parse(String fileName) {
			// TODO Auto-generated method stub
			System.out.println(fileName + " - XML parsing completed.");
		}
		
	}
	
	class HTMLParser implements Parseable {

		@Override
		public void parse(String fileName) {
			// TODO Auto-generated method stub
			System.out.println(fileName + " - HTML parsing completed.");
		}
		
	}
	
	
	public void main(){
		Parseable parser = this.getParser("XML");
		parser.parse("document.xml");
		parser = this.getParser("HTML");
		parser.parse("document.html");
	}
}
