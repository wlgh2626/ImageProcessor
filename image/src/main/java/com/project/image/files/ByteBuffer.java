package com.project.image.files;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

public class ByteBuffer {
	public static final byte[] BIG_ENDIAN_VALUE = { 0x4D, 0x4D };
	public static final byte[] LITTLE_ENDIAN_VALUE = { 0x49, 0x49 };
	private enum ByteOrder{
		BIG_ENDIAN,
		LITTLE_ENDIAN;
	}
	ByteOrder order;
	public ByteBuffer(byte[] data) {
		order = Arrays.equals(data, BIG_ENDIAN_VALUE) ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN;
	}
	
	public byte[] read(byte[] array) {
		if(order == ByteOrder.LITTLE_ENDIAN) {
			ArrayUtils.reverse(array);
		}
		return array;
	}
	
	public byte[] read(byte[] array, int begin , int end) {
		array = Arrays.copyOfRange(array, begin, end);
		return read(array);
	}
	
}
