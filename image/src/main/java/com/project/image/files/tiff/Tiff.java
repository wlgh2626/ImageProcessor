package com.project.image.files.tiff;

import java.util.Arrays;

import com.project.image.files.ByteBufferReader;
import com.project.image.files.Convert;
import com.project.image.files.tiff.image.Image;

public class Tiff{
	Header header;
	Image image;
	ImageFileDirectory ifd;
	
	public Tiff(byte[] data) throws Exception {
		header = new Header(Arrays.copyOfRange(data, 0, 8));
		ByteBufferReader reader = ByteBufferReader.getInstance();
		
		int begin = header.getOffset();
		int numEntries = Convert.toUnsignedInt(reader.read(data, begin, begin+2));
		int end = (numEntries * ImageFileDirectory.ENTRY_SIZE) + begin + 2;

		ifd = new ImageFileDirectory(reader.read(data, begin, end));
	}
	
	public Header getHeader() {
		return header;
	}
	
	public ImageFileDirectory getIFD() {
		return ifd;
	}
	
}
