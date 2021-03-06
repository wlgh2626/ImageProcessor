package com.project.image.application;

import java.io.File;
import java.nio.file.Files;

import com.project.image.files.tiff.Tiff;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageHandler {
	private ImageView imageView;
	public ImageHandler() {
		imageView = new ImageView();
	}
	public void setImageView(File file) throws Exception {
		byte[] data = Files.readAllBytes(file.toPath());
		Tiff tiff = new Tiff(data);
		Image image = SwingFXUtils.toFXImage(tiff.getImageList().get(0).getImage() , null);
		imageView.setImage(image);
	}
	public ImageView getImageView() {
		return imageView;
	}
}
