package com.project.image.application;

import java.io.File;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ImageOrganizer{
	private Scene scene;
	private VBox vBox;
	private ImageHandler imageHandler;
	private FileChooser fileChooser;
	private File selectedFile;
	private Button fileButton;
	
	public ImageOrganizer (Stage stage) throws Exception {
		fileChooser = new FileChooser();
		imageHandler = new ImageHandler();
		vBox = new VBox();
        scene = new Scene(vBox, 960, 600);
        
		fileButton = new Button("Select File");
        fileButton.setOnAction(e -> {
            try {
            	selectedFile = fileChooser.showOpenDialog(stage);
				imageHandler.setImageView(selectedFile);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
        });
        vBox.getChildren().add(fileButton);
        vBox.getChildren().add(imageHandler.getImageView());
	}
	
	public Scene getScene() {
		return scene;
	}
	
	
	
	
	

}
