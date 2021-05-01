package com.project.image.tiff.header;

import java.math.BigInteger;
import java.util.Arrays;

import com.project.image.properties.Properties.ByteOrder;
import com.project.image.properties.Properties.FileType;
import com.project.image.util.ByteReader;

public class Header {
	public static final int HEADER_SIZE = 8;
	public static final byte[] TIFF_VALUE = { 0x0, 0x2A };
	public static final byte[] BIG_ENDIAN_VALUE = { 0x4D, 0x4D };
	public static final byte[] LITTLE_ENDIAN_VALUE = { 0x49, 0x49 };

	ByteOrder order = ByteOrder.BIG_ENDIAN; // 0 - 1
	FileType fileType; // 2 - 3
	byte[] offset; // 4 - 7

	public Header(byte[] header) throws Exception { // Read the 8 bytes long TIFF header
		order = Arrays.equals(ByteReader.INSTANCE.read(header, 0, 2), BIG_ENDIAN_VALUE) ? ByteOrder.BIG_ENDIAN
				: ByteOrder.LITTLE_ENDIAN;

		ByteReader.INSTANCE.setByteOrder(order); // Set all reads to Big/Little Endian
		fileType = Arrays.equals(ByteReader.INSTANCE.read(header, 2, 4), TIFF_VALUE) ? FileType.TIFF : FileType.UNKNOWN;

		if (!fileType.equals(FileType.TIFF))
			throw new Exception("The given FileType is " + fileType + ". Only TIFF file is accepted");
		offset = ByteReader.INSTANCE.read(header, 4, 8);
	}

	public ByteOrder getByteOrder() {
		return order;
	}

	public FileType getFileType() {
		return fileType;
	}

	public Integer getOffSet() {
		return (new BigInteger(offset).intValue());
	}

}
