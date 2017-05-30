
public class CaptionTvTest {

	public void main(){
		CaptionTv ctv = new CaptionTv();
		ctv.channel = 10;
		ctv.channelUp();
		System.out.println(ctv.channel);
		
		ctv.displayCaption("Hello, World");
		ctv.caption = true;
		ctv.displayCaption("Hello, World");
	}
}

class Tv{
	boolean power;
	int channel;
	
	void power() { power = !power; }
	void channelUp() { ++channel; }
	void channelDown() { --channel; }
}

class CaptionTv extends Tv{
	boolean caption;		//	cpation status ( on / off )
	
	void displayCaption(String text){
		if(caption){		//	if caption is on, show text.
			System.out.println(text);
		}
	}
}

