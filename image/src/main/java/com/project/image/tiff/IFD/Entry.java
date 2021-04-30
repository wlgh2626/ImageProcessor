package com.project.image.tiff.IFD;

import com.project.image.tiff.IFD.tags.Names.TagName;
import com.project.image.tiff.IFD.tags.FieldTypes.FieldType;

public class Entry {
	TagName tagName;	//0 - 1
	FieldType fieldType; //2 - 3
	byte[] value; // 4 - 7
	byte[] offset; // 8 - 12
	public Entry(byte[] IFDEntry) {
		
	}
}
