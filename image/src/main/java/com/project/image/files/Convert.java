package com.project.image.files;

import java.math.BigInteger;
import java.util.Arrays;

public class Convert {
	public static Integer toUnsignedInt(byte[] data) { // 1 byte long
		return new BigInteger(data).intValue();
	}
	
	public static Integer toUInt(byte[] data, int begin, int end) { // 1 byte long
		return new BigInteger(Arrays.copyOfRange(data, begin, end)).intValue();
	}

	public static Short toUnsigedShort(byte[] data) { // 2 bytes long
		return new BigInteger(data).shortValue();
	}

	public static Long toUnsigedLong(byte[] data) { // 2 bytes long
		return new BigInteger(data).longValue();
	}
	
	public static String toHexString(byte[] data) {
		return new BigInteger(1, data).toString(16);
	}

	/*
	 * public static char toASCII() { // 7 bits long, 8th bit is 0(NUL); return 'a';
	 * }
	 */

}
