package com.project.image.files.tiff.ifd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.project.image.files.tiff.ifd.Tags.TagName;
import com.project.image.files.tiff.util.ByteBufferReader;
import com.project.image.files.tiff.util.BytesConverter;

public class ImageFileDirectory {
	public static final int ENTRY_SIZE = 12;

	private HashMap<TagName, Entry> tagValue = new HashMap<TagName, Entry>();
	private int numEntries;
	private int nextOffset = 0;

	public ImageFileDirectory(byte[] data, int beginIndex, ByteBufferReader reader) {
		int numEntries = BytesConverter.toUnsignedInt(reader.read(data, beginIndex, beginIndex + 2));

		int end = (numEntries * ImageFileDirectory.ENTRY_SIZE) + beginIndex + 2;
		byte[] IFDData = Arrays.copyOfRange(data, beginIndex + 2, end);
		Entry.Builder entryBuilder = new Entry.Builder(data, reader);

		for (int index = 0; index < IFDData.length; index += ENTRY_SIZE) {
			Entry entry = entryBuilder.build(Arrays.copyOfRange(IFDData, index, index + ENTRY_SIZE));
			tagValue.put(entry.getTagName(), entry);
		}
		nextOffset = BytesConverter.toUnsignedInt(reader.read(data, end, end + 4));
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

	public ArrayList<Integer> tagToValue(TagName name) {
		return tagValue.get(name).getValues();
	}
}
