package HangmanStuff;

import java.io.FileInputStream;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MainMenu extends Application {
	Button startButton;
	Button exitButton;
	final Alert confirmation = new Alert(AlertType.CONFIRMATION);
	Stage secondaryStage = new Stage();
	final ImageView selectedImage = new ImageView();

	@Override
	public void start(Stage primaryStage) throws Exception {
		startButton = new Button("Start Game!");
		startButton.setText("START GAME");
		startButton.setTextFill(Color.RED);
		startButton.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

		EventHandler<MouseEvent> clickStart = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				DifficultyMenu dm = new DifficultyMenu();
				try {
					dm.start(secondaryStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// close the main menu window
				primaryStage.hide();
			}
		};

		startButton.addEventHandler(MouseEvent.MOUSE_CLICKED, clickStart);

		exitButton = new Button();
		exitButton.setText("EXIT GAME");
		exitButton.setTextFill(Color.RED);
		exitButton.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

		EventHandler<MouseEvent> clickExit = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Optional<ButtonType> result = confirmation.showAndWait();
				if (result.get() == ButtonType.OK) {
					System.exit(0);
				}
			}
		};
		exitButton.addEventHandler(MouseEvent.MOUSE_CLICKED, clickExit);
		startButton.addEventHandler(MouseEvent.MOUSE_CLICKED, clickStart);

		startButton.setScaleX(1.5);
		startButton.setScaleY(1.5);
		exitButton.setScaleX(1.5);
		exitButton.setScaleY(1.5);

		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		root.setSpacing(20);

		Scene scene = new Scene(root, 600, 600);
		Image titleImage = new Image(
				new FileInputStream("C:/Users/HP/Downloads/Images/HangManGame/HangManGameTitle-Edited.jpg"));
		selectedImage.setImage(titleImage);

		root.getChildren().addAll(startButton, exitButton);
		root.setBackground(
				new Background(new BackgroundImage(titleImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
						BackgroundPosition.CENTER, new BackgroundSize(768, 1366, false, false, true, false))));

		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Main Menu!");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
