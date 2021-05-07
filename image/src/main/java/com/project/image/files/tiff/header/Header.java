package com.project.image.files.tiff.header;

import java.math.BigInteger;
import java.util.Arrays;

import com.project.image.files.ByteBuffer;
import com.project.image.files.Properties.FileType;

public class Header{
	public static final byte[] TIFF_VALUE = { 0x0, 0x2A };

	FileType fileType; // 2 - 3
	byte[] offset; // 4 - 7

	public Header(byte[] header, ByteBuffer buffer) throws Exception { // Read the 8 bytes long TIFF header
		fileType = Arrays.equals(buffer.read(header, 2, 4), TIFF_VALUE) ? FileType.TIFF : FileType.UNKNOWN;
		validateFileType();
		offset = buffer.read(header, 4, 8);
	}

	public FileType getFileType() {
		return fileType;
	}

	public Integer getOffSet() {
		return (new BigInteger(offset).intValue());
	}
	
	void validateFileType() throws Exception {
		if (!fileType.equals(FileType.TIFF)) {
			throw new Exception("The given FileType is " + fileType + ". Only TIFF file is accepted");
		}
	}

}
