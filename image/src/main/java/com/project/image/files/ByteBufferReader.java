package com.project.image.files;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

public class ByteBufferReader {
	private static ByteBufferReader instance = null;
	private final ByteOrder byteOrder;
	public enum ByteOrder{
		BIG_ENDIAN,
		LITTLE_ENDIAN;
	}
	
	private ByteBufferReader(ByteOrder byteOrder) {
		this.byteOrder = byteOrder;
	}
	
	public static ByteBufferReader ByteBufferReader(ByteOrder byteOrder) {
		if(instance == null) {
			instance = new ByteBufferReader(byteOrder);
		}
		return instance;
	}
	public static ByteBufferReader getInstance() {
		return instance;
	}
	
	public byte[] read(byte[] array) {
		if(byteOrder == ByteOrder.LITTLE_ENDIAN) {
			ArrayUtils.reverse(array);
		}
		return array;
	}
	
	public byte[] read(byte[] array, int begin , int end) {
		array = Arrays.copyOfRange(array, begin, end);
		return read(array);
	}
	
}
