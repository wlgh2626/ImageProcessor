package com.project.image.files.tiff;

import java.util.Arrays;

import com.project.image.files.ByteBufferReader;
import com.project.image.files.Convert;
import com.project.image.files.tiff.IFD.tags.ImageFileDirectory;
import com.project.image.files.tiff.IFD.tags.TagNames.TagName;
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
		int end = (numEntries * ImageFileDirectory.ENTRY_SIZE) + begin + 6;

		ifd = new ImageFileDirectory(data , Arrays.copyOfRange(data, begin, end));
		//ifd.getEntryList().fi
	}
	
	public Header getHeader() {
		return header;
	}
	
	public ImageFileDirectory getIFD() {
		return ifd;
	}
	
}
