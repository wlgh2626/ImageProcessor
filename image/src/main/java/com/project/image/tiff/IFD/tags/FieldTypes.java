package com.project.image.tiff.IFD.tags;

public class FieldTypes {
	public enum FieldType{
		BYTE(1),
		ASCII(2),
		SHORT(3),
		LONG(4),
		RATIONAL(5),
		SBYTE(6),
		UNDEFINED(7),
		SSHORT(8),
		SLONG(9),
		SRATIONAL(10),
		FLOAT(11),
		DOUBLE(12);
		
		private int value;
		private FieldType(int value) {
			this.value = value;
		}
		public int getValue() {
		    return value;
		}
	}
}
