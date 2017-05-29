package chapter_06;

public class OverloadingTest {

	
	//	int, long형 매개변수가 하나씩 선언되어 있지만, 서로 순서가 다른 경우이다.
	//	호출 시 매개변수의 값에 의해 호출될 메서드가 구분되기 때문에 오버로딩으로 간주한다.
	long add(int a, long b) { return a+b; }
	long add(long a, int b) { return a+b; }
}
