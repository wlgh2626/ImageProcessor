package com.project.image.files.tiff.IFD.tags;

import java.util.ArrayList;
import java.util.List;

import com.project.image.files.ByteBufferReader;
import com.project.image.files.Convert;
import com.project.image.files.tiff.IFD.tags.FieldTypes.FieldType;
import com.project.image.files.tiff.IFD.tags.TagNames.TagName;


//TODO accept all Number class instead of only Integer
public class Entry{	//12 bytes long
	private TagName tagName;		 //0 - 1	2bytes long
	private FieldType fieldType; 	 //2 - 3	2bytes long
	private int count; 		 		 //4 - 7	4bytes long
	private ArrayList<Integer> values;	
	public Entry(byte[] data, byte[] IFDData) {
		if(IFDData.length != 12) throw new java.lang.Error("IFD Entry must be 12 bytes long");

		IFDData = ByteBufferReader.getInstance().read(IFDData);
		tagName = TagName.iToName( toUInt(IFDData,0,2) );
		fieldType = FieldType.fieldTypeOf( toUInt(IFDData,2,4) );	//Double, integer, etc ...
		count = toUInt(IFDData,4,8);
		
		int offset = toUInt( IFDData, 8 , 12);	//offset : 8 - 11	4bytes long
		int fieldLength = fieldType.getLength(); 
		int valueSize = fieldLength * count;
			
		values = new ArrayList<Integer>();
		if(valueSize > 4) {
			for(int i = 0 ; i < count ; i ++ ) {
				values.add( toUInt(data, offset , offset+fieldLength) );
				offset += fieldLength;
			}
		} else {
			int currentIndex = 8;
			for(int i = 0 ; i < count ; i++) {
				values.add( toUInt(IFDData, currentIndex , currentIndex+fieldLength) );
				currentIndex += fieldLength;
			}	
		}
		
	}
	
	@Override
	public String toString() {
		return "Tag Name: " 	+ tagName.name() + "\n" +
				"Field Type: " 	+ fieldType.name() + "\n" +
				"Count: " 		+ count + "\n" +
				"Offset/Value: "+ values.toString() + "\n";
	}
	
	public TagName getTagName() {
		return tagName;
	}
	public FieldType getFieldType() {
		return fieldType;
	}
	public ArrayList<Integer> getValues() {
		return (ArrayList)List.copyOf(values);
	}
	public int getCount() {
		return count;
	}
	
	private int toUInt(byte[] data, int begin, int end) {
		return Convert.toUnsignedInt(ByteBufferReader.getInstance().read(data,begin,end));
	}
}
