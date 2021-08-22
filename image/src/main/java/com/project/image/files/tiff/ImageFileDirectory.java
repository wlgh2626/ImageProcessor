package com.project.image.files.tiff;

import java.util.ArrayList;

import com.project.image.files.ByteBufferReader;
import com.project.image.files.Convert;
import com.project.image.files.tiff.IFD.tags.FieldTypes.FieldType;
import com.project.image.files.tiff.IFD.tags.Names.TagName;

public class ImageFileDirectory {
	public static final int ENTRY_SIZE = 12;
	
	private ArrayList<Entry> entryList = new ArrayList<Entry>();	
	private int numEntries;
	private int nextIFDOffset = 0;
	
	public ImageFileDirectory(byte[] data) {	
		ByteBufferReader reader = ByteBufferReader.getInstance();
		data = reader.read(data);
		numEntries = Convert.toUnsignedInt( reader.read(data,0,2));
		for(int index = 2 ; index < data.length; index+=ENTRY_SIZE) {
			byte[] currentData = reader.read(data , index , index+ENTRY_SIZE);
			entryList.add(new Entry(currentData));
		}
	}
	
	public ArrayList<Entry> getEntryList() {
		return entryList;
	}
	
	public class Entry{	//12 bytes long
		private TagName tagName;		 //0 - 1	2bytes long
		private FieldType fieldType; 	 //2 - 3	2bytes long
		private int count; 		 		 //4 - 7	4bytes long
		private int offset;		 		 //8 - 12	4bytes long
		public Entry(byte[] IFDEntry) {
			if(IFDEntry.length != 12) {
				throw new java.lang.Error("IFD Entry must be 12 bytes long");
			}
			ByteBufferReader reader = ByteBufferReader.getInstance();
			IFDEntry = reader.read(IFDEntry);
			tagName = TagName.iToName(Convert.toUnsignedInt( reader.read(IFDEntry,0,2)));
			fieldType = FieldType.fieldTypeOf(Convert.toUnsignedInt(reader.read(IFDEntry,2,4)));
			count = Convert.toUnsignedInt(reader.read(IFDEntry, 4,8));
			offset = Convert.toUnsignedInt(reader.read(IFDEntry,8,12));
			
		}
		public TagName getTagName() {
			return tagName;
		}
		public FieldType getFieldType() {
			return fieldType;
		}
		public int getOffset() {
			return offset;
		}
		public int getCount() {
			return count;
		}
		@Override
		public String toString() {
			return "Tag Name: " 	+ tagName.name() + "\n" +
					"Field Type: " 	+ fieldType.name() + "\n" +
					"Count: " 		+ count + "\n" +
					"Offset/Value: "+ offset + "\n";
		}
	}
}



// Number of Directory Entries 	(2)
// Entry 1 						(14)
// Entry 2						(26)
// ...
// Entry N						(N*12+2)
// Offset to Next IFD			(N*12+2) + (4)