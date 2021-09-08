package com.project.image.application;

import javafx.application.Application;
import javafx.stage.Stage;


public class App extends Application
{
    public static void main( String[] args )
    {
       launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		ImageOrganizer imageOrganizer = new ImageOrganizer(primaryStage);  
        
      
        primaryStage.setTitle("ImageView");
        primaryStage.setScene(imageOrganizer.getScene());
        primaryStage.show();
	}
}
