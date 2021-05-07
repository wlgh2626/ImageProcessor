package com.project.image.files.tiff;

import java.util.Arrays;

import com.project.image.files.ByteBuffer;
import com.project.image.files.Conversion;
import com.project.image.files.tiff.IFD.IFD;
import com.project.image.files.tiff.header.Header;
import com.project.image.files.tiff.image.Image;

public class Tiff{
	public static final int HEADER_SIZE = 8;
	
	Header header;
	Image image;
	IFD ifd;

	public Tiff(byte[] data) throws Exception {
		
		ByteBuffer buffer = new ByteBuffer(Arrays.copyOfRange(data, 0, 2));	
		header = new Header(Arrays.copyOfRange(data, 0, 8), buffer);
		
		int ifdBegin = header.getOffSet();
		int numIFDEntries = Conversion.toUnsignedInt(buffer.read(data,ifdBegin, ifdBegin+2));
		int ifdEnd = (numIFDEntries * IFD.ENTRY_SIZE) + 2;

		ifd = new IFD(buffer.read(data,ifdBegin,ifdEnd), buffer);

	}
	
}
