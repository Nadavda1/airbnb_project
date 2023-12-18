package application;

import javafx.stage.Stage;
import model.Model;
import view.View;
import controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;


public class Main extends Application {
	Stage window;

	public void start(Stage primaryStage) throws Exception {
		
		Stage stage = primaryStage;
		
		Model model = new Model();
		Controller controller = new Controller(model);
		View view = new View(controller, primaryStage);
		
		primaryStage.show();

	}

	public void switchScenes(Scene scene) {
		window.setScene(scene);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
