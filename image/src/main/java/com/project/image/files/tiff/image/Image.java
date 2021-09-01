package com.project.image.files.tiff.image;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.project.image.files.tiff.util.ByteBufferReader;

public class Image {
	
	private int width;
	private int length;
	private Pixel[][] pixels;
	public Image(Builder builder) {
		width = builder.width;
		length = builder.length;
	}
	
	public static class Builder{
		private byte[] data;
		private ByteBufferReader reader;
		
		private ArrayList<Integer> offsets; 
		private ArrayList<Integer> byteCounts;
		private int width;
		private int length;
		private int[] bitsPerSample;
		
		public Builder(byte[] data) {
			this.data = data;
		}
		public Builder width(int value) {
			width = value;
			return this;
		}
		public Builder length(int value) {
			length = value;
			return this;
		}
		public Builder bitsPerSample(int[] value) {
			bitsPerSample = value;
			return this;
		}
		public Builder offsets(ArrayList<Number> value) {
			offsets = new ArrayList<Integer>(value.stream().map(Number::intValue).collect(Collectors.toList()));
			return this;
		}
		public Builder byteCounts(ArrayList<Number> value) {
			byteCounts = new ArrayList<Integer>(value.stream().map(Number::intValue).collect(Collectors.toList()));
			return this;
		}
		
		public Image build() {
			ArrayList<Pixel> pixels = new ArrayList<>();
			while((!offsets.isEmpty()) && (!byteCounts.isEmpty())) {
				int offset = offsets.remove(0);
				int byteCount = byteCounts.remove(0);
				for(int i = offset ; i < offset+byteCount ; i+=3) {
					pixels.add(new Pixel.Builder()
									.red(data[i])
									.green(data[i+1])
									.blue(data[i+2])
									.build() 
								);
				}
			}
			return new Image(this);
		}
		
		public void validate() {
			if(offsets.size() != byteCounts.size()) {
				throw new java.lang.Error("stripOffset and stripByteCount must be equal length!\n" + 
											"offset Size :" + offsets.size() + "\n" +
											"byteCount Size :" + byteCounts.size() + "\n");
			}
		}
		
	}
}
