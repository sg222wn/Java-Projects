package HangmanStuff;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Instructions extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button goBack;
		Text instructions = new Text();
		goBack = new Button("Go to Main Menu");
		goBack.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				MainMenu mm = new MainMenu();
				try {
					mm.start(new Stage());
				} catch (Exception e) {
					e.printStackTrace();
				}
				primaryStage.hide();
			}
		});



		String instructionsString = "You have to guess a random word letter by letter.\n If you guess the correct letter, you will progress through the game without losing a life.\n"
				+ "If you guess the wrong letter then, you lose a life and still continue the game, until you reach \nthe point where you have no lives left.\n"
				+ "If you want to pause the game during gameplay then you can click on the pause button on \nthe bottom of the screen.";
		instructions.setText(instructionsString);
		instructions.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
		
		VBox root = new VBox();
		Scene scene = new Scene(root, 800, 150);
		root.getChildren().addAll(instructions, goBack);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Instructions");
		primaryStage.show();

		
	}

}
