package com.project.image.files.tiff.image;

public class Pixel {
	private int red;
	private int green;
	private int blue;
	public Pixel(Builder builder) {
		red = builder.red;
		green = builder.green;
		blue = builder.blue;
	}
	
	public static class Builder{
		private int red;
		private int green;
		private int blue;
		
		public Builder red(int value) {
			red = value;
			return this;
		}
		public Builder green(int value) {
			green = value;
			return this;
		}
		public Builder blue(int value) {
			blue = value;
			return this;
		}
		public Pixel build() {
			return new Pixel(this);
		}
	}
}
