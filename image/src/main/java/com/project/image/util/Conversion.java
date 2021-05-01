package com.project.image.util;

import java.math.BigInteger;

public class Conversion {
	public static Integer toUnsignedInt(byte[] data) { // 1 byte long
		return new BigInteger(data).intValue();
	}

	public static Short toUnsigedShort(byte[] data) { // 2 bytes long
		return new BigInteger(data).shortValue();
	}

	public static Long toUnsigedLong(byte[] data) { // 2 bytes long
		return new BigInteger(data).longValue();
	}

	/*
	 * public static char toASCII() { // 7 bits long, 8th bit is 0(NUL); return 'a';
	 * }
	 */

}
