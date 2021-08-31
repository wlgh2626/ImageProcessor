package com.project.image.files.tiff.ifd;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Tags {
	public static interface Tag {
		public int getValue();
	}
	
	public static class TagImpl implements Tag {
		int value;

		public int getValue() {
			return value;
		}

		public TagImpl(int value) {
			this.value = value;
		}
	}
	
	public enum TagName { // TAG
		UNKNOWN(-1), NEW_SUBFILE_TYPE(254), SUBFILE_TYPE(255), IMAGE_WIDTH(256), IMAGE_LENGTH(257),
		BITS_PER_SAMPLE(258), COMPRESSION(259), PHOTOMETRIC_INTERPRETATION(262), THRESHOLDING(263), CELL_WIDTH(264),
		CELL_LENGTH(265), FILL_ORDER(266), IMAGE_DESCRIPTION(270), MAKE(271), MODEL(272), STRIPS_OFF_SETS(273),
		ORIENTATION(274), SAMPLES_PER_PIXEL(277), ROWS_PER_STRIP(278), STRIP_BYTE_COUNTS(279), MIN_SAMPLE_VALUE(280),
		MAX_SAMPLE_VALUE(281), X_RESOLUTION(282), Y_RESOLUTION(283), PLANAR_CONFIGURATION(284), FREE_OFFSETS(288),
		FREE_BYTE_COUNTS(289), GARY_RESPONSE_UNIT(290), GRAY_RESPONSE_CURVE(291), RESOLUTION_UNIT(296), SOFTWARE(305),
		HOST_COMPUTER(316), COLOR_MAP(320), EXTRA_SAMPLES(338);

		private final int tagNumber;

		private TagName(int tagNumber) {
			this.tagNumber = tagNumber;
		}

		public int getTagNumber() {
			return tagNumber;
		}

		private static Map<Integer, TagName> iToName = new HashMap<Integer, TagName>();
		static {
			for (TagName name : TagName.values()) {
				iToName.put(name.getTagNumber(), name);
			}
		}

		public static TagName iToName(int value) {
			return iToName.containsKey(value) ? iToName.get(value) : UNKNOWN;
		}

	}
	
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

	public enum Compression implements Tag {
		NONE(1), CCITT(2), PACKBITS(32773);

		private Tag tag;
		public static Map<Integer, Tag> iToTag = Collections.unmodifiableMap(buildMap(Compression.values()));

		private Compression(int value) {
			tag = new TagImpl(value);
		}

		@Override
		public int getValue() {
			return tag.getValue();
		}
	}

	public enum PhotometricInterpretation implements Tag {
		WHITE_IS_ZERO(0), BLACK_IS_ZERO(1), RGB(2), PALETTE(3), TRANSPARENCY_MASK(4);

		private Tag tag;
		public static Map<Integer, Tag> iToTag = Collections.unmodifiableMap(buildMap(Compression.values()));

		private PhotometricInterpretation(int value) {
			tag = new TagImpl(value);
		}

		@Override
		public int getValue() {
			return tag.getValue();
		}
	}

	public enum PlanarConfiguration implements Tag {
		CHUNKY(1), PLANAR(2);

		private Tag tag;
		public static Map<Integer, Tag> iToTag = Collections.unmodifiableMap(buildMap(Compression.values()));

		private PlanarConfiguration(int value) {
			tag = new TagImpl(value);
		}

		@Override
		public int getValue() {
			return tag.getValue();
		}
	}

	public enum ResolutionUnit implements Tag {
		VARY(1), INCH(2), CENTIMETER(3);

		private Tag tag;
		public static Map<Integer, Tag> iToTag = Collections.unmodifiableMap(buildMap(Compression.values()));

		private ResolutionUnit(int value) {
			tag = new TagImpl(value);
		}

		@Override
		public int getValue() {
			return tag.getValue();
		}
	}
	
	static Map<Integer, Tag> buildMap(Tag[] tagEntry) {
		HashMap<Integer, Tag> iToTag = new HashMap<Integer, Tag>();
		for (Tag t : tagEntry) {
			iToTag.put(t.getValue(), t);
		}
		return iToTag;
	}
	
	
}
