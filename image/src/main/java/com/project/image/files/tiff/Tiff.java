package com.project.image.files.tiff;

import java.util.Arrays;

import com.project.image.files.ByteBufferReader;
import com.project.image.files.Conversion;
import com.project.image.files.tiff.image.Image;

public class Tiff{
	Header header;
	Image image;
	ImageFileDirectory ifd;
	ByteBufferReader bufferReader;
	public Tiff(byte[] data) throws Exception {
		header = new Header(Arrays.copyOfRange(data, 0, 8));
		bufferReader = header.getBufferReader();
		int ifdBegin = header.getOffset();
		int numIFDEntries = Conversion.toUnsignedInt(bufferReader.read(data,ifdBegin, ifdBegin+2));
		int ifdEnd = (numIFDEntries * ImageFileDirectory.ENTRY_SIZE) + 2;

		ifd = new ImageFileDirectory(bufferReader.read(data,ifdBegin,ifdEnd), bufferReader);

	}
	
	public Header getHeader() {
		return header;
	}
	
}
