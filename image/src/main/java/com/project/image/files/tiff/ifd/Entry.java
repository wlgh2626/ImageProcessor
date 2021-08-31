package com.project.image.files.tiff.ifd;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.project.image.files.tiff.ifd.Tags.FieldType;
import com.project.image.files.tiff.ifd.Tags.TagName;
import com.project.image.files.tiff.util.ByteBufferReader;
import com.project.image.files.tiff.util.BytesConverter;

//TODO accept all Number class instead of only Integer
public class Entry { // 12 bytes long
	private TagName tagName; // 0 - 1 2bytes long
	private FieldType fieldType; // 2 - 3 2bytes long
	private int count; // 4 - 7 4bytes long
	private ArrayList<Integer> values = new ArrayList<Integer>();

	public Entry(Builder builder) {
		tagName = builder.tagName;
		fieldType = builder.fieldType;
		count = builder.values.size();
		values = builder.values;
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

	public static class Builder {
		private final static Logger logger = Logger.getLogger(Entry.class.getName());
		private final byte[] data;
		private final ByteBufferReader reader;
		TagName tagName;
		FieldType fieldType;
		ArrayList<Integer> values;

		public Builder(byte[] data, ByteBufferReader reader) {
			this.data = data;
			this.reader = reader;
		}

		public Entry build(byte[] IFDData) {
			tagName = TagName.iToName(toUInt(IFDData, 0, 2));
			fieldType = FieldType.iToField(toUInt(IFDData, 2, 4));
			values = new ArrayList<Integer>();
			int count = toUInt(IFDData, 4, 8);

			int currentIndex = 8;
			byte[] currentData = IFDData;
			if (fieldType.getLength() * count > 4) {
				currentIndex = toUInt(IFDData, 8, 12);
				currentData = data;
			}

			for (int i = 0; i < count; i++) {
				values.add(toUInt(currentData, currentIndex, currentIndex + fieldType.getLength()));
				currentIndex += fieldType.getLength();
			}
			validate(IFDData);
			return new Entry(this);
		}

		private int toUInt(byte[] data, int begin, int end) {
			return BytesConverter.toUnsignedInt(reader.read(data, begin, end));
		}

		private void validate(byte[] IFDData) {
			if (IFDData.length != 12)
				throw new java.lang.Error("Must be 12 bytes long");
			if (tagName == TagName.UNKNOWN) {
				logger.log(Level.WARNING, "Unkown Tag Name detected: " + toUInt(IFDData, 0, 2));
			}
		}
	}
}
