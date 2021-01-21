import static org.junit.Assert.*;

import java.util.function.Function;

import org.junit.Test;

public class CklmCodeTest {

	@Test
	public void testReverseArray() {
		Number[] originalArray = { 1, 2, 3, 4, 5 };
		Number[] expectedArray = { 5, 4, 3, 2, 1 };		
		assertArrayEquals(expectedArray, CklmCode.reverseArray(originalArray));
	}

	@Test
	public void testUppercaseArray() {
		String[] originalArray = {"dog", "cat", "bird"};
		String[] upperArray = {"DOG", "CAT", "BIRD"};
		assertArrayEquals(upperArray, CklmCode.uppercaseArray(originalArray));
	}

	@Test
	public void testFindWordCount() {
		int numWords = 3;
		String word = "cat";
		String text = "dog cat bird cat cat";
		assertEquals(numWords, CklmCode.findWordCount(text, word));
	}

	@Test
	public void testComposeU() {
		try {
			Integer numExpected = 13;
			Function<Integer, Integer> add = (value) -> value + 3;
			Function<Integer, Integer> multiply = (value) -> value * 2;
			Function<Integer, Integer> result = CklmCode.composeU(add, multiply);
			assertEquals(numExpected, result.apply(5));
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(expected = InvalidNameException.class)
	public void testCheckCorrectNameNull() throws InvalidNameException {
		CklmCode.checkCorrectName(null);
	}
	
	@Test(expected = InvalidNameException.class)
	public void testCheckCorrectNameBlank() throws InvalidNameException {
		CklmCode.checkCorrectName("");
	}
	
	@Test(expected = InvalidNameException.class)
	public void testCheckCorrectNameNumbers() throws InvalidNameException {
		CklmCode.checkCorrectName("");
	}
}
