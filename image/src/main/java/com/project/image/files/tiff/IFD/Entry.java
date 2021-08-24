package com.project.image.files.tiff.ifd;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.project.image.files.tiff.ByteBufferReader;
import com.project.image.files.tiff.ifd.FieldTypes.FieldType;
import com.project.image.files.tiff.ifd.TagNames.TagName;
import com.project.image.files.util.BytesConverter;

//TODO accept all Number class instead of only Integer
public class Entry { // 12 bytes long
	private static Logger logger = Logger.getLogger(Entry.class.getName());

	private byte[] IFDData;
	private TagName tagName; // 0 - 1 2bytes long
	private FieldType fieldType; // 2 - 3 2bytes long
	private int count; // 4 - 7 4bytes long
	private ArrayList<Integer> values = new ArrayList<Integer>();

	public Entry(byte[] data, byte[] IFDData) {
		this.IFDData = ByteBufferReader.getInstance().read(IFDData);
		fieldType = FieldType.iToField(toUInt(IFDData, 2, 4));
		count = toUInt(IFDData, 4, 8);
		tagName = TagName.iToName(toUInt(IFDData, 0, 2));
		checkValidity();

		// if count*fieldSize is bigger than 4 bytes,consider the 8 - 11 value offset
		int currentIndex = (fieldType.getLength() * count) > 4 ? toUInt(IFDData, 8, 12) : 8;
		byte[] currentData = (fieldType.getLength() * count) > 4 ? data : IFDData;
		for (int i = 0; i < count; i++) {
			values.add(toUInt(currentData, currentIndex, currentIndex + fieldType.getLength()));
			currentIndex += fieldType.getLength();
		}

	}

	public TagName getTagName() {
		return tagName;
	}

	public FieldType getFieldType() {
		return fieldType;
	}

	public ArrayList<Integer> getValues() {
		return new ArrayList<Integer>(List.copyOf(values));
	}

	public int getCount() {
		return count;
	}

	@Override
	public String toString() {
		return "Tag Name: " + tagName.name() + "\n" + "Field Type: " + fieldType.name() + "\n" + "Count: " + count
				+ "\n" + "Offset/Value: " + values.toString() + "\n";
	}

	private void checkValidity() {
		if (IFDData.length != 12)
			throw new java.lang.Error("IFD Entry must be 12 bytes long");

		if (tagName == TagName.UNKNOWN) {
			logger.log(Level.WARNING, "Unkown Tag Name detected: " + toUInt(IFDData, 0, 2));
		}
	}

	private int toUInt(byte[] data, int begin, int end) {
		return BytesConverter.toUnsignedInt(ByteBufferReader.getInstance().read(data, begin, end));
	}
}
