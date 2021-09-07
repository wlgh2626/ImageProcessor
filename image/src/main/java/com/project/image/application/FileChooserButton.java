package com.project.image.application;

import java.io.File;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileChooserButton{
	ImageHandler imageHandler;
	FileChooser fileChooser;
	File selectedFile;
	Button button;
	public FileChooserButton (Stage stage) throws Exception {
		fileChooser = new FileChooser();
		button = new Button("Select File");
        button.setOnAction(e -> {
            try {
            	selectedFile = fileChooser.showOpenDialog(stage);
				imageHandler = new ImageHandler(selectedFile);
				
				 VBox vBox = new VBox();
			     vBox.getChildren().add(imageHandler.getImageView());
			     Scene scene = new Scene(vBox, 960, 600);
			     stage.setScene(scene);
			     
			} catch (Exception e1) {
				e1.printStackTrace();
			}
        });
	}
	
	public Button getButton() {
		return button;
	}
	
	public File getSelectedFile() {
		return selectedFile;
	}
	
	public ImageHandler getImageHandler() {
		return imageHandler;
	}
	
	
	

}
