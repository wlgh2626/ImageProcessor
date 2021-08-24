package com.project.image.files.tiff.image;

public class Image {
	private int width;
	private int height;
	public Image(ImageBuilder builder) {
		width = builder.width;
		height = builder.height;
	}
	
	public static class ImageBuilder{
		private int width;
		private int height;
		public ImageBuilder width(int value) {
			width = value;
			return this;
		}
		public ImageBuilder height(int value) {
			height = value;
			return this;
		}
		public Image build() {
			return new Image(this);
		}
	}
}
