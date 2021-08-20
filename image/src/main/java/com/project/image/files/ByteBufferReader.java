package com.project.image.files;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

public class ByteBufferReader {
	public enum ByteOrder{
		BIG_ENDIAN,
		LITTLE_ENDIAN;
	}
	public final ByteOrder byteOrder;
	public ByteBufferReader(ByteOrder byteOrder) {
		this.byteOrder = byteOrder;
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
