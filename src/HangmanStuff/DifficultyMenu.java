package HangmanStuff;

import java.io.FileInputStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DifficultyMenu extends Application {

	private Button easy;
	private Button medium;
	private Button pro;
	private Button goBack;
	Stage gameplayStage = new Stage();
	HangmanMain hm = new HangmanMain();
	final ImageView selectedImage = new ImageView();

	@Override
	public void start(Stage primaryStage) throws Exception {
		easy = new Button("NOOB");
		medium = new Button("SLIGHTLY AVERAGE");
		pro = new Button("PROFESSIONAL");
		goBack = new Button("Go to Main Menu");

		Image titleImage = new Image(new FileInputStream("C:/Users/HP/Downloads/Images/HangManGame/127.jpg"));

		easy.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				hm.setLife(12);
				try {
					hm.start(gameplayStage);
				} catch (Exception e) {
					e.printStackTrace();
				}
				primaryStage.hide();
			}
		});

		medium.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				hm.setLife(9);
				try {
					hm.start(gameplayStage);
				} catch (Exception e) {
					e.printStackTrace();
				}
				primaryStage.hide();
			}
		});
		pro.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				hm.setLife(6);
				try {
					hm.start(gameplayStage);
				} catch (Exception e) {
					e.printStackTrace();
				}
				primaryStage.hide();
			}
		});
		goBack.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				MainMenu mm = new MainMenu();
				try {
					mm.start(gameplayStage);
				} catch (Exception e) {
					e.printStackTrace();
				}
				primaryStage.hide();
			}
		});

		
		VBox root = new VBox();

		root.setAlignment(Pos.CENTER);
		root.setSpacing(20);

		root.getChildren().addAll(easy, medium, pro, goBack);
		root.setBackground(
				new Background(new BackgroundImage(titleImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
						BackgroundPosition.CENTER, new BackgroundSize(768, 1366, false, false, true, false))));

		Scene scene = new Scene(root, 400, 400);

		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
