package com.project.image.files.tiff.IFD.tags;

import java.util.ArrayList;

import com.project.image.files.ByteBufferReader;
import com.project.image.files.Convert;

public class ImageFileDirectory {
	public static final int ENTRY_SIZE = 12;
	
	private ArrayList<Entry> entryList = new ArrayList<Entry>();	
	private int numEntries;
	private int nextOffset = 0;	//NEXT IFD offset
	
	public ImageFileDirectory(byte[] data, byte[] IFDData) {	
		numEntries = toUInt(IFDData,0,2);
		for(int index = 2 ; index < IFDData.length-4 ; index+=ENTRY_SIZE) {	//read 2 - 14 , 14 - 26 , 26 - 38 ...
			byte[] currentData = ByteBufferReader.getInstance().read(IFDData , index , index+ENTRY_SIZE);
			entryList.add(new Entry(data, currentData));
		}
		nextOffset = toUInt(IFDData, IFDData.length-4 , IFDData.length);	//last 4 bits of IFDData
	}
	
	public ArrayList<Entry> getEntryList() {
		return entryList;
	}
	public int getNextOffset() {
		return nextOffset;
	}
	public int getNumEntries() {
		return numEntries;
	}
	
	private int toUInt(byte[] data, int begin, int end) {
		return Convert.toUnsignedInt(ByteBufferReader.getInstance().read(data,begin,end));
	}
}



// Number of Directory Entries 	(2)
// Entry 1 						(14)
// Entry 2						(26)
// ...
// Entry N						(N*12+2)
// Offset to Next IFD			(N*12+2) + (4)