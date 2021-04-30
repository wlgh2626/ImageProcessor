package com.project.image.util;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

import com.project.image.tiff.header.Properties;
import com.project.image.tiff.header.Properties.ByteOrder;

public enum ByteReader {
	INSTANCE;
	ByteOrder order = ByteOrder.BIG_ENDIAN;
	public void toBigEndian() {
		order = ByteOrder.BIG_ENDIAN;
	}

	public void toLittleEndian() {
		order = ByteOrder.LITTLE_ENDIAN;
	}
	
	public void setByteOrder(ByteOrder order) {
		this.order = order;
	}
	
	
	public byte[] read(byte[] array) {
		if(order == ByteOrder.LITTLE_ENDIAN) {
			ArrayUtils.reverse(array);
		}
		return array;
	}
	
	public byte[] read(byte[] array, int begin , int end) {
		array = Arrays.copyOfRange(array, begin, end);
		if(order == ByteOrder.LITTLE_ENDIAN) {
			ArrayUtils.reverse(array);
		}
		return array;
	}
}
