import java.io.FileInputStream;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainMenu extends Application {
	Button startButton;
	Button exitButton;
	final Alert confirmation = new Alert(AlertType.CONFIRMATION);
	Stage secondaryStage = new Stage();

	@Override
	public void start(Stage primaryStage) throws Exception {
		startButton = new Button("Start Game!");
		startButton.setScaleX(1);
		startButton.setScaleY(1);
		startButton.relocate(683, 304);
		EventHandler<MouseEvent> clickStart = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				HangmanMain hm = new HangmanMain();
				try {
					hm.start(secondaryStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		startButton.addEventHandler(MouseEvent.MOUSE_CLICKED, clickStart);

		exitButton = new Button("Exit game!");
		exitButton.relocate(683, 344);

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

		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, 1366, 768);
		final ImageView selectedImage = new ImageView();
		Image titleImage = new Image(
				new FileInputStream("C:/Users/HP/Downloads/Images/HangManGame/HangManGameTitle-Edited.jpg"));
		selectedImage.setX(-100);
		selectedImage.setY(-683);
		selectedImage.setScaleX(0.5);
		selectedImage.setScaleY(0.5);
		selectedImage.setImage(titleImage);

		root.getChildren().add(selectedImage);
		root.getChildren().addAll(startButton, exitButton);
		primaryStage.setScene(scene);

		primaryStage.setTitle("Main Menu!");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
