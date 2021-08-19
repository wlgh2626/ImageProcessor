package com.project.image.files.tiff.IFD.tags;

public class TagImpl implements Tag{
	int value;
	public int getValue() {
		return value;
	}
	public TagImpl(int value) {
		this.value = value;
	}
}
