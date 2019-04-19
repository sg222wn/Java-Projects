package HangmanStuff;

public class GameBasicVersion {

	public static void main(String args[]) {
		String word = "Hello";
		char one = 'e';
		char two = 'l';

		String result = word.replaceAll("" + one, "-");
		result = result.replaceAll("" + two, "-");
		System.out.println(result);

		String solved = "";
		for (int i = 0; i < word.length(); i++) {
			System.out.println(word.charAt(i) + "&" + result.charAt(i));
			if (word.charAt(i) == result.charAt(i)) {
				solved += "-";
			} else {
				solved += word.charAt(i);
			}
		}

		System.out.println(solved);
	}
}
