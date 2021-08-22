package com.project.image.files.tiff;

import java.math.BigInteger;
import java.util.Arrays;

import com.project.image.files.ByteBufferReader;
import com.project.image.files.ByteBufferReader.ByteOrder;
import com.project.image.files.Convert;
import com.project.image.files.Properties.FileType;

public class Header{
	public static final byte[] BIG_ENDIAN_VALUE = { 0x4D, 0x4D };
	public static final byte[] LITTLE_ENDIAN_VALUE = { 0x49, 0x49 };
	public static final byte[] TIFF_VALUE = { 0x0, 0x2A };

	ByteOrder byteOrder; 	//0 - 1
	FileType fileType; 		// 2 - 3
	byte[] offset; 			// 4 - 7
	ByteBufferReader bufferReader;

	public Header(byte[] header) throws Exception { // Read the 8 bytes long TIFF header
		byteOrder = Arrays.copyOfRange(header, 0, 2).equals(BIG_ENDIAN_VALUE) ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN;
		bufferReader = ByteBufferReader.ByteBufferReader(byteOrder);	
		
		fileType = Arrays.equals(bufferReader.read(header, 2, 4), TIFF_VALUE) ? FileType.TIFF : FileType.UNKNOWN;
		validateFileType();
		offset = bufferReader.read(header, 4, 8);
	}

	public FileType getFileType() {
		return fileType;
	}

	public Integer getOffset() {
		return (new BigInteger(offset).intValue());
	}
	
	public ByteBufferReader getBufferReader() {
		return bufferReader;
	}
	
	public ByteOrder getByteOrder() {
		return byteOrder;
	}
	
	private void validateFileType() throws Exception {
		if (!fileType.equals(FileType.TIFF)) {
			throw new Exception("The given FileType is " + fileType + ". Only TIFF file is accepted");
		}
	}
	
	@Override
	public String toString() {
		return "Byte Order : " + byteOrder.name() + "\n" +
			   "File Type : " + fileType.name() + "\n" +
			   "Offset to IFD : " + getOffset() + "\n" ;
	}

}
