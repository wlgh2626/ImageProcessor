package com.project.image.files.tiff.IFD;


import java.util.ArrayList;

import com.project.image.files.ByteBuffer;
import com.project.image.files.Conversion;

public class IFD{
	public static final int ENTRY_SIZE = 12;
	ArrayList<Entry> entryList = new ArrayList<Entry>();// Each entry has Name , DataType, TagEntry
	int numEntries;
	

	public IFD(byte[] data, ByteBuffer buffer) {
		numEntries = Conversion.toUnsignedInt(buffer.read(data,0,2));
		for(int i = 2 ; i < data.length; i+=ENTRY_SIZE) {
			//entryList.add(new Entry(read(data , i , i+ENTRY_SIZE)));
		}
	}
}
