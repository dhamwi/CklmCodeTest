
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public class CklmCode {
	public static void main(String[] args) {
		
		/**
		 * Write a console application that accepts a random sequence of numbers and
		 * loops through looking for 2 equal, consecutive numbers. When found write
		 * 'Snap' to the console else print out the number (e.g. 1,3,5,5,'Snap').
		 */
		puzzle();		 
	}

	/**
	 * Create a function that accepts an array of numbers and returns a reversed
	 * array (e.g. [1,2,3] would be [3,2,1]
	 * 
	 * @param input
	 * @return
	 */
	public static Number[] reverseArray(Number[] input) {
		Collections.reverse(Arrays.asList(input));
		return input;
	}

	/**
	 * Write a function that transforms an array of strings to an upper-case array
	 * of strings
	 * 
	 * @param input
	 * @return
	 */
	public static String[] uppercaseArray(String[] input) {
		List<String> list = Arrays.asList(input);
		list.replaceAll(element -> element.toUpperCase());
		return list.toArray(new String[0]);
	}

	/**
	 * Counts the number of times a word appears in a text
	 * 
	 * @param text Text where find the word
	 * @param wordToFind Word to find
	 * @return
	 */
	public static int findWordCount(String text, String wordToFind) {
		int wordCount = 0;
		try {
			List<String> wordsList = Arrays.asList(text.split(" "));
			wordCount = (int) (wordsList.stream().filter(word -> word.equals(wordToFind)).count());
		} catch (NullPointerException error) {
			error.printStackTrace();
		}
		return wordCount;
	}

	/**
	 * Given a sentence create a function that returns the number of unique words
	 * 
	 * @param text
	 */
	public static void getNumberUniqueWords(String text) {
		if (text == null || text.isBlank()) {
			System.out.println("The text is empty.");
		} else {
			Map<String, Integer> wordsMap = new HashMap<String, Integer>();
			List<String> wordsList = Arrays.asList(text.split(" "));

			wordsList.stream().filter(word -> !wordsMap.containsKey(word)).forEach(word -> {
				wordsMap.put(word, findWordCount(text, word));
			});
			wordsMap.forEach((key, value) -> System.out.println(key + " : " + value));
		}
	}

	/**
	 * Write a function 'composeu' that takes two unary functions and returns a
	 * unary function that calls them both
	 * 
	 * @param f1
	 * @param f2
	 * @return
	 */
	public static Function<Integer, Integer> composeU(Function<Integer, Integer> f1, Function<Integer, Integer> f2) {
		return f1.compose(f2);
	}

	/**
	 * Write a function that reads from a file and prints the contents to the
	 * console
	 * 
	 * @param filePath
	 * @return
	 */
	public static String writeContentsToConsole(String filePath) {
		StringBuilder contentBuilder = new StringBuilder();
		try {
			Stream<String> stream = Files.lines(Paths.get(filePath));
			stream.forEach(s -> contentBuilder.append(s).append("\n"));
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contentBuilder.toString();
	}

	/**
	 * Write a function that reads from a file and prints the contents to the
	 * console
	 */
	public static void writeContentsToConsole() {
		String filePath = "D://file.txt";
		try {
			Stream<String> stream = Files.lines(Paths.get(filePath));
			stream.forEach(s -> System.out.println(s));
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Give an example of how a function would handle an invalid argument
	 * 
	 * Check if a name is correctly spelled
	 * 
	 * @param name
	 * @throws InvalidNameException
	 */
	public static void checkCorrectName(String name) throws InvalidNameException {
		if (name == null || name.isBlank()) {
			throw new InvalidNameException(0);
		} else if (name.matches(".*\\d.*")) {
			throw new InvalidNameException(1);
		}
	}

	/**
	 * Write a console application that accepts a random sequence of numbers and
	 * loops through looking for 2 equal, consecutive numbers. When found write
	 * 'Snap' to the console else print out the number (e.g. 1,3,5,5,'Snap').
	 * 
	 * @throws IOException
	 */
	public static void puzzle() {

		System.out.println("Insert a number and press enter. Insert 'E' to EXIT.");

		String text = null;
		List<Integer> listNumber = new ArrayList<Integer>();
		Scanner reader = new Scanner(System.in);

		do {
			try {
				text = reader.next();
				if (text.matches("[0-9]+")) {
					int number = Integer.valueOf(text);
					if (listNumber.contains(number)) {
						listNumber.add(number);
						System.out.print("Snap!!! ");
						break;
					}
					listNumber.add(number);
				} else if (!text.toUpperCase().equals("E")) {
					System.out.println("You can only insert numbers!!!");
				}
			} catch (java.lang.NumberFormatException error) {
				System.out.println("It is a number too long!!!");
			}
		} while (!text.toUpperCase().equals("E"));

		reader.close();
		if (text.toUpperCase().equals("E")) {
			System.out.println("You have finished the execution...");
		} else {
			listNumber.forEach(n -> System.out.print(n + " "));
		}
	}
}