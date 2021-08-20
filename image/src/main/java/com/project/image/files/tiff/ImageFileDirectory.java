package com.project.image.files.tiff;

import java.util.ArrayList;

import com.project.image.files.ByteBufferReader;
import com.project.image.files.Conversion;
import com.project.image.files.tiff.IFD.tags.FieldTypes.FieldType;
import com.project.image.files.tiff.IFD.tags.Names.TagName;

public class ImageFileDirectory {
	public static final int ENTRY_SIZE = 12;
	ArrayList<Entry> entryList = new ArrayList<Entry>();	
	int numEntries;
	

	public ImageFileDirectory(byte[] data, ByteBufferReader buffer) {
		numEntries = Conversion.toUnsignedInt(buffer.read(data,0,2));
		for(int index = 2 ; index < data.length; index+=ENTRY_SIZE) {
			byte[] currentData = buffer.read(data , index , index+ENTRY_SIZE);
			//entryList.add();
		}
	}
}

class Entry{
	final TagName tagName;		 //0 - 1	2bytes long
	final FieldType fieldType; 	 //2 - 3	2bytes long
	final byte[] count; 		 //4 - 7	4bytes long
	final byte[] offset;		 //8 - 12	4bytes long
	public Entry(byte[] IFDEntry, ByteBufferReader buffer) {
		
		tagName = TagName.iToName(Conversion.toUnsignedInt(buffer.read(IFDEntry,0,2)));
		fieldType = FieldType.fieldTypeOf(Conversion.toUnsignedInt(buffer.read(IFDEntry,2,4)));
		count = buffer.read(IFDEntry, 4,8);
		offset = buffer.read(IFDEntry,8,12);
		
	}
}