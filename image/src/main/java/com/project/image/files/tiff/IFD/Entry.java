package com.project.image.files.tiff.IFD;

import com.project.image.files.ByteBuffer;
import com.project.image.files.Conversion;
import com.project.image.files.tiff.IFD.tags.FieldTypes;
import com.project.image.files.tiff.IFD.tags.Names;
import com.project.image.files.tiff.IFD.tags.FieldTypes.FieldType;
import com.project.image.files.tiff.IFD.tags.Names.TagName;

public class Entry{
	//final TagName tagName;		 //0 - 1	2bytes long
	//final FieldType fieldType; 	 //2 - 3	2bytes long
	//final byte[] value; 		 //4 - 7	4bytes long
	//final byte[] offset;		 //8 - 12	4bytes long
	//ByteOrder order;
	public Entry(byte[] IFDEntry, ByteBuffer buffer) {
		/*
		tagName = TagName.nameOf(ByteReader.INSTANCE.toUnsignedInt(IFDEntry,0,2));
		fieldType = FieldType.fieldTypeOf(ByteReader.INSTANCE.toUnsignedInt(IFDEntry,2,4));
		value = ByteReader.INSTANCE.read(IFDEntry, 4,8);
		offset = ByteReader.INSTANCE.read(IFDEntry,8,12);
		*/
	}
}
