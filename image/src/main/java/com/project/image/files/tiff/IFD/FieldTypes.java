package com.project.image.files.tiff.ifd;

import java.util.HashMap;
import java.util.Map;

public class FieldTypes {
	public enum FieldType{
		BYTE(1,1),
		ASCII(2,1),
		SHORT(3,2),
		LONG(4,4),
		RATIONAL(5,8),
		SBYTE(6,1),
		UNDEFINED(7,1),
		SSHORT(8,2),
		SLONG(9,4),
		SRATIONAL(10,8),
		FLOAT(11,4),
		DOUBLE(12,8);
		
		private static Map<Integer, FieldType> intToFieldType = new HashMap<Integer, FieldType>();
		static {
			for(FieldType name : FieldType.values()) {
				intToFieldType.put(name.getValue(), name);
			}
		}
		public static FieldType iToField(int value) {
			return intToFieldType.get(value);
		}
		
		private int value;
		private int byteLength;
		private FieldType(int value, int byteLength) {
			this.value = value;
			this.byteLength = byteLength;
		}
		
		public int getValue() {
		    return value;
		}
		public int getLength() {
			return byteLength;
		}
	}
}
