package bonus;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestMeTest {

	@Test
	public void mainQuestion() {
		TestMe testMe = new TestMe();
		int answer = testMe.mainQuestion(2,2);
		assertEquals(4, answer);
	}
	@Test
	public void mainQuestion1() {
		TestMe testMe = new TestMe();
		int answer = testMe.mainQuestion(2,3);
		assertEquals(5, answer);
	}
	@Test
	public void mainQuestion2() {
		TestMe testMe = new TestMe();
		int answer = testMe.mainQuestion(2,-2);
		assertEquals(0, answer);
	}
	@Test
	public void mainQuestion3() {
		TestMe testMe = new TestMe();
		int answer = testMe.mainQuestion(-2,-2);
		assertEquals(-4, answer);
	}

}



