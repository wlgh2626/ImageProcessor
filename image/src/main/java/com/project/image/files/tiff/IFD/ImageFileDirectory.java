package com.project.image.files.tiff.ifd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.project.image.files.tiff.ByteBufferReader;
import com.project.image.files.tiff.ifd.TagNames.TagName;
import com.project.image.files.util.BytesConverter;

public class ImageFileDirectory {
	public static final int ENTRY_SIZE = 12;

	private HashMap<TagName, Entry> tagValue = new HashMap<TagName, Entry>();
	private int numEntries;
	private int nextOffset = 0; // NEXT IFD offset

	public ImageFileDirectory(byte[] data, int beginIndex) {
		int numEntries = BytesConverter.toUnsignedInt( ByteBufferReader.getInstance().read(data, beginIndex, beginIndex + 2));
		int end = (numEntries * ImageFileDirectory.ENTRY_SIZE) + beginIndex + 6;
		
		byte[] IFDData = Arrays.copyOfRange(data, beginIndex, end);
		for (int index = 2; index < IFDData.length - 4; index += ENTRY_SIZE) { // read 2 - 14 , 14 - 26 , 26 - 38 ...
			byte[] currentData = ByteBufferReader.getInstance().read(IFDData, index, index + ENTRY_SIZE);
			Entry entry = new Entry(data, currentData);
			tagValue.put(entry.getTagName(), entry);
		}
		nextOffset = toUInt(IFDData, IFDData.length - 4, IFDData.length); // last 4 bits of IFDData
	}

	public ArrayList<Entry> getEntryList() {
		return new ArrayList<Entry>(tagValue.values());
	}

	public int getNextOffset() {
		return nextOffset;
	}

	public int getNumEntries() {
		return numEntries;
	}

	public ArrayList<Integer> valueOf(TagName name) {
		return tagValue.get(name).getValues();
	}

	private int toUInt(byte[] data, int begin, int end) {
		return BytesConverter.toUnsignedInt(ByteBufferReader.getInstance().read(data, begin, end));
	}
}
