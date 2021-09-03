package com.project.image;

import java.io.File;
import java.nio.file.Files;

import org.junit.Test;

import com.project.image.files.tiff.Tiff;
import com.project.image.files.tiff.ifd.ImageFileDirectory;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
public class ImageTest extends Application{
	File balloonsFile = new File(Tiff.TIFF_DIRECTORY + "/balloons.tif");
	File autumnFile = new File(Tiff.TIFF_DIRECTORY + "/autumn.tif");
	File boardFile = new File(Tiff.TIFF_DIRECTORY + "/board.tif");
	File brainFile = new File(Tiff.TIFF_DIRECTORY + "/brain.tif");
	File columnsFile = new File(Tiff.TIFF_DIRECTORY + "/columns.tif");
	File lenaFile = new File(Tiff.TIFF_DIRECTORY + "/lena.tif");

	@Test
	public void balloonsIFDTest() throws Exception {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		byte[] balloonsData = Files.readAllBytes(columnsFile.toPath());
		Tiff tiff = new Tiff(balloonsData);
		for (ImageFileDirectory ifd : tiff.getIFDList()) {
			System.out.println(ifd.toString());
		}
		
		Image image = SwingFXUtils.toFXImage(tiff.getImageList().get(0).getImage() , null);
		ImageView imageView = new ImageView();
		imageView.setImage(image);
		
		Group root = new Group();
        Scene scene = new Scene(root);
        HBox box = new HBox();
        box.getChildren().add(imageView);
        root.getChildren().add(box);
        
        primaryStage.setTitle("ImageView");
        primaryStage.setScene(scene); 
        primaryStage.sizeToScene(); 
		primaryStage.show();
	}
}

