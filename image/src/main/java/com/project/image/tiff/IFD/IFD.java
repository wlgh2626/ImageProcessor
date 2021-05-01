package com.project.image.tiff.IFD;

import java.math.BigInteger;
import java.util.Arrays;

public class IFD {
	public static final int ENTRY_SIZE = 12;

	int numEntries;
	Entry[] entries; // Each entry has Name , DataType, TagEntry

	public IFD(byte[] data) {
		numEntries = new BigInteger(Arrays.copyOfRange(data, 0, 2)).intValue();
	}
}
