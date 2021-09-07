package com.project.image.application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class App extends Application
{
    public static void main( String[] args )
    {
       launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		FileChooserButton fileChooser = new FileChooserButton(primaryStage);  
        
        VBox vBox = new VBox();
        vBox.getChildren().add(fileChooser.getButton());
        Scene scene = new Scene(vBox, 960, 600);
        
        primaryStage.setTitle("ImageView");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
}
