package com.project.image.files.tiff.image;

public class Image {
	private int width;
	private int length;
	public Image(ImageBuilder builder) {
		width = builder.width;
		length = builder.length;
	}
	
	public static class ImageBuilder{
		private int width;
		private int length;
		public ImageBuilder width(int value) {
			width = value;
			return this;
		}
		public ImageBuilder length(int value) {
			length = value;
			return this;
		}
		public Image build() {
			return new Image(this);
		}
	}
}
