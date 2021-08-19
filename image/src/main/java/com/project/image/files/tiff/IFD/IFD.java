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
		for(int index = 2 ; index < data.length; index+=ENTRY_SIZE) {
			byte[] currentData = buffer.read(data , index , index+ENTRY_SIZE);
			//entryList.add();
		}
	}
}
