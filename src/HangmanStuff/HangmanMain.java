package HangmanStuff;

import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HangmanMain extends Application {

	public String[] wordArray = { "Hello", "India", "Trump", "Obama", "Duck", "Goose", "Holy", "Trinity", "Potter",
			"Faith", "theme", "song", "Rover", "time", "ardent", "always", "wither", "miss", "Friends", "Love", "Happy",
			"Positive", "Beautiful", "Gorgeous", "Abundant", "Soul", "Whisper", "Enigma", "Hope", "journey", "glitch",
			"existence", "closer", "sandwich", "music", "movies", "life", "sunset", "twilight", "hangman", "help",
			"comic", "British", "breezy", "heart", "wander", "lust", "java", "online", "controller", "around", "doctor",
			"software", "dream", "lucid", "lights", "downtown", "china", "wall", "crazy", "teenage", "midnight",
			"memories", "rock", "meet", "hangout", "bullet", "group", "another", "treat", "better", "truth", "honesty",
			"humble", "victory", "stream", "Avicii", "waiting", "wind", "lost", "older", "free", "wild", "follow",
			"eyes", "learn", "carry", "middle", "figure", "tear", "Vader", "America", "cross", "Family", "city",
			"Marvel", "beats", "human", "spring", "summer" };
	public String word = wordArray[(int) (Math.random() * 99)];
	private String[] dumbText = new String[word.length()];
	private String inputText = "";
	private int lifeCounter = 12;
	public boolean winOrLose = false;
	private Alert winMessage;
	private Alert exceptionMessage;
	private Text wordTxt = new Text();
	private Text resultText = new Text();
	public String finalWord = "";

	BorderPane mainPane;
	BorderPane bp;
	BorderPane bp1;

	public void setLife(int life) {
		this.lifeCounter = life;
	}

	public int getLife() {
		return lifeCounter;
	}

	// Methods written for the sake of testing
	/*public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
*/
	// This is the method that returns the wrong value for JUnit test and also the method that generates the dashes for guessing
	private String getDashes() {
		String dashes = "";
		for (int i = 0; i < word.length(); i++) {
			dashes += "-";
		}
		return dashes;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Declaring the buttons
		Button pauseButton;
		Alert mainMenuAlert = new Alert(AlertType.CONFIRMATION);

		TextField textBox = new TextField();
		textBox.setScaleX(0.60);
		textBox.setAlignment(Pos.BASELINE_LEFT);
		// Formatting the buttons
		pauseButton = new Button();
		pauseButton.setText("Pause Game");
		pauseButton.setScaleY(1.2);
		pauseButton.setScaleX(1.2);

		wordTxt.setText(word);
		wordTxt.setFill(Color.WHITE);
		wordTxt.setFont(Font.font("Times New Roman", FontWeight.BOLD, 45));

		resultText.setText(word);
		resultText.setFill(Color.WHITE);
		resultText.setFont(Font.font("Times New Roman", FontWeight.BOLD, 45));

		Text clue = new Text();
		clue.setLayoutX(200);
		clue.setLayoutY(200);
		clue.setFont(Font.font("Helvetica", FontWeight.MEDIUM, 22));
		clue.setText("Guess the " + word.length() + " letter word to save a life: ");

		Text titleText = new Text("Guess the word");
		titleText.setFont(Font.font("Times New Roman", FontWeight.BOLD, 45));
		titleText.setLayoutX(50);
		titleText.setLayoutY(90);

		Text livesLeft = new Text();
		Text gameOver = new Text();
		gameOver.setLayoutX(50);
		gameOver.setLayoutY(200);

		resultText.setText(getDashes());
		resultText.setFill(Color.BLACK);

		// Once "Check" button is clicked, will check if the character is present in the
		// word or not

		textBox.setOnKeyReleased(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				inputText = textBox.getText();
				containsLetter(inputText);
				livesLeft.setText("Remaining Lives: " + lifeCounter);
				textBox.setText("");
				if (lifeCounter == 0) {
					gameOver.setText("Game Over");
				}
			}
		});
		pauseButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				mainMenuAlert.setContentText("Click OK to go to Main Menu!");
				Optional<ButtonType> result = mainMenuAlert.showAndWait();
				if (result.get() == ButtonType.OK) {
					MainMenu mm = new MainMenu();
					try {
						mm.start(new Stage());
					} catch (Exception e) {
						e.printStackTrace();
					}
					primaryStage.hide();
				}
			}
		});

		livesLeft.setLayoutX(50);
		livesLeft.setLayoutY(180);

		// All the BorderPanes
		BorderPane mainPane = new BorderPane();
		BorderPane bp = new BorderPane();
		BorderPane bp1 = new BorderPane();
		BorderPane bp2 = new BorderPane();

		BorderPane.setAlignment(resultText, Pos.TOP_LEFT);
		BorderPane.setAlignment(clue, Pos.TOP_LEFT);
		BorderPane.setAlignment(textBox, Pos.BOTTOM_LEFT);
		BorderPane.setAlignment(gameOver, Pos.TOP_LEFT);
		BorderPane.setAlignment(livesLeft, Pos.TOP_CENTER);
		BorderPane.setAlignment(pauseButton, Pos.TOP_LEFT);

		bp.setCenter(resultText);
		bp.setBottom(pauseButton);

		bp1.setCenter(livesLeft);
		bp1.setTop(gameOver);

		bp2.setCenter(textBox);
		bp2.setLeft(clue);

		mainPane.setCenter(bp);
		mainPane.setRight(bp1);
		mainPane.setTop(bp2);
		mainPane.setBackground(new Background(new BackgroundFill(Color.AQUA, null, null)));
		Scene scene = new Scene(mainPane, 400, 200);

		// Final Stages
		primaryStage.setTitle("The HangMan Game");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	// displays whether the player has won or lost
	// This is an important method but has not been used in program to prevent errors during testing
	private void displayEndMessage() {
		if (winOrLose == true) {
			winMessage = new Alert(AlertType.INFORMATION);
			winMessage.setContentText("Congrats! You Saved a Life!!");
			winMessage.show();
		} else {
			winMessage = new Alert(AlertType.INFORMATION);
			winMessage.setContentText(
					"You messed up! Big time!!" + "\nThe word you were looking for is: " + wordTxt.getText());
			winMessage.show();
		}
	}

	// This method will check whether the entered character exists in the word or
	// not
	private void containsLetter(String c) {
		try {
			word = word.toLowerCase();
			c = c.toLowerCase();
			char s = c.charAt(0);
			for (int i = 0; i < word.length(); i++) {
				if (word.charAt(i) == s) {
					dumbText[i] = wordTxt.getText().charAt(i) + "";
					resultText.setText(toString(dumbText));
					resultText.setFill(Color.BLACK);
					finalWord = resultText.getText();
				}
			}
			if (!(word.contains(inputText.charAt(0) + ""))) {
				lifeCounter--;
			}
			checkIfGameOver();
		} catch (StringIndexOutOfBoundsException s) {
			s = new StringIndexOutOfBoundsException("Please Enter a Letter!!");
			exceptionMessage = new Alert(AlertType.INFORMATION);
			exceptionMessage.setContentText(s.getMessage());
			exceptionMessage.show();
		}
	}

	// convert array to string
	private String toString(String[] a) {
		String s = "";
		for (int i = 0; i < a.length; i++) {
			if (a[i] == null) {
				a[i] = "-";
				s += a[i];
			}
			s += a[i];
		}
		return s;
	}

	public void checkIfGameOver() {
		if (word.equals(finalWord) && lifeCounter > 0) {
			winOrLose = true;
			// This is used to display to the user whether you have won or lost but has been commented out for testing
			displayEndMessage();
		} else if (lifeCounter == 0) {
			winOrLose = false;
			// This is used to display to the user whether you have won or lost but has been commented out for testing
			displayEndMessage();
		}
	}

	// For testing's sake Not used in actual program
/*	  public String getFinalWord() { return finalWord; }
	  
	  public void setFinalWord(String finalWord) { this.finalWord = finalWord; }
*/	 
	public static void main(String[] args) {
		launch(args);
	}

}
