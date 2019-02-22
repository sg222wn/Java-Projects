import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HangmanMain extends Application {

	String word = "Hello";
	Button check;
	String text = "";
	int lifeCounter = 5;
	String dashes = "-----";
	Timer timer = new Timer();
	TimerTask exitApp = new TimerTask() {
		public void run() {
			System.exit(0);
		}
	};

	public void TimedExit() {
		timer.schedule(exitApp, new Date(System.currentTimeMillis() + 5 * 1000));
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		TextField textBox = new TextField();
		textBox.setLayoutX(50);
		textBox.setLayoutY(100);
		check = new Button();
		check.setText("Check!");
		check.setLayoutX(50);
		check.setLayoutY(140);

		Text clue = new Text();
		clue.setLayoutX(200);
		clue.setLayoutY(200);
		clue.setFont(Font.font("Times New Roman", FontWeight.BOLD, 45));
		for (int i = 0; i < word.length(); i++) {
			dashes += "-";
		}
		clue.setText(dashes);

		Text titleText = new Text("Guess the word");
		titleText.setFont(Font.font("Times New Roman", FontWeight.BOLD, 45));
		titleText.setLayoutX(50);
		titleText.setLayoutY(90);

		Text livesLeft = new Text();
		Text gameOver = new Text();
		gameOver.setLayoutX(50);
		gameOver.setLayoutY(200);
		EventHandler<MouseEvent> clickCheck = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				text = textBox.getText();
				containsLetter(text.charAt(0));
				textBox.setText("");
				clue.setText(dashes);
				livesLeft.setText("Remaining Lives: " + lifeCounter);
				if (lifeCounter == 0) {
					gameOver.setText("Game Over");
					TimedExit();
				}
			}

		};
		livesLeft.setLayoutX(50);
		livesLeft.setLayoutY(180);
		while (lifeCounter > 0) {
			check.addEventHandler(MouseEvent.MOUSE_CLICKED, clickCheck);
		}
		AnchorPane aPane = new AnchorPane();
		Scene scene = new Scene(aPane, 1366, 768);
		aPane.getChildren().addAll(titleText, textBox, clue, check, livesLeft, gameOver);
		primaryStage.setTitle("HangMain");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private boolean containsLetter(char c) {
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == c) {
				dashes = dashes.replaceAll(dashes.charAt(i) + "", word.charAt(i) + "");
				if(dashes.equals(word)) {
					// You have won the game
				}
				return true;
			}
		}
		lifeCounter--;
		return false;

	}

/*	public void run() {
		System.out.println(
				"This is the first Iteration of a Hangman Game! For this, try and guess the most commonly used greet word!");
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
*/
	public static void main(String[] args) {
		launch(args);
	}
}
