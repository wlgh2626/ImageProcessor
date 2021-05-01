package com.project.image.tiff;

import java.util.Arrays;

import com.project.image.tiff.IFD.IFD;
import com.project.image.tiff.header.Header;
import com.project.image.tiff.image.Image;
import com.project.image.util.ByteReader;
import com.project.image.util.Conversion;

public class Tiff {

	byte[] data;
	Header header;
	Image image;
	IFD ifd;

	public Tiff(byte[] data) throws Exception {
		this.data = data;
		header = new Header(Arrays.copyOfRange(data, 0, 8));

		int ifdBegin = header.getOffSet();
		int numIFDEntries = Conversion.toUnsignedInt(getRange(ifdBegin, ifdBegin+2));
		int ifdEnd = (numIFDEntries * IFD.ENTRY_SIZE) + 2;

		ifd = new IFD(getRange(ifdBegin, ifdEnd));

	}
	
	byte[] getRange(int begin, int end) {
		return ByteReader.INSTANCE.read(Arrays.copyOfRange(data, begin, end));
	}
}
