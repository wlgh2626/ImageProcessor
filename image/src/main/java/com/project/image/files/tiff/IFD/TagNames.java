package com.project.image.files.tiff.ifd;

import java.util.HashMap;
import java.util.Map;

public class TagNames {
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
}
