package HangmanStuff;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class HangmanJUnitTests {

	// This test is used to check whether the correct life is set based on
	// difficulty level.
	@Test
	void lifeTest() {
		HangmanMain hm = new HangmanMain();
		hm.setLife(12);
		assertEquals(12, hm.getLife());
	}

	// This test is used to check whether the words from the String array is the
	// same as that of the string that was sent in.
	@Test
	void testSettingAndGettingWordsFromArray() {
		HangmanMain hm = new HangmanMain();
		hm.setWord(hm.wordArray[2]);
		String collectedWord = hm.getWord();
		assertEquals("Trump", collectedWord);
	}

	// This test is used to check whether the array elements are properly converted
	// into a string.
	@Test
	void testArrayToString() {
		HangmanMain hm = new HangmanMain();
		String[] testArray = { "h", "e", "l", "l", "o" };
		String testString = "hello";
		assertEquals(hm.toString(testArray), testString);
	}

	// This test is used to check whether the boolean value for Winning or Losing
	// the game is set properly
	@Test
	void testGameOverMethod() {
		HangmanMain hm = new HangmanMain();
		hm.setWord("Test");
		hm.setFinalWord("Test");
		hm.setLife(12);
		hm.checkIfGameOver();
		boolean getWinOrLoseGame = hm.winOrLose;
		assertEquals(true, getWinOrLoseGame);
	}

	// This test is used to check whether the correct number of dashes are set based
	// on the word size.
	// This is also the test that fails on purpose
	@Test
	void testSetDashes() {
		HangmanMain hm = new HangmanMain();
		String wordDashes = "";
		for (int i = 0; i < hm.word.length(); i++) {
			wordDashes += "-";
		}
		String expectedDashes = hm.getDashes();
		assertEquals(wordDashes, expectedDashes);
	}

}
