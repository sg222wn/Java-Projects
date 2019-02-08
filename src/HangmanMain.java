import java.util.Scanner;

public class HangmanMain {

	public static void main(String[] args) {
		System.out.println(
				"This is the first Iteration of a Hangman Game! For this, try and guess the most commonly used greet word!");
		String word = "Hello";
		String hyphens = "";
		for (int i = 0; i < word.length(); i++) {
			hyphens += "-";
		}

		// getting character input from user
		char[] inputChar = new char[word.length()];
		Scanner input = new Scanner(System.in);
		System.out.println(hyphens);
		System.out.println("Enter characters!");
		for (int i = 0; i < word.length(); i++) {
			inputChar[i] = input.next().charAt(0);
		}
		// replacing hyphens with characters
		String result = "";
		for (int i = 0; i < word.length(); i++) {
			if (i == 0)
				result = word.replaceAll("" + inputChar[i], "-");
			else
				result = result.replaceAll("" + inputChar[i], "-");
		}

		String solved = "";
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == result.charAt(i)) {
				solved += "-";
			} else {
				solved += word.charAt(i);
			}
		}
		input.close();
		System.out.println(solved);
	}

}
