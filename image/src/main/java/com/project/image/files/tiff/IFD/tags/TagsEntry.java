package com.project.image.files.tiff.IFD.tags;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TagsEntry {
	public enum Compression implements Tag{
		NONE(1),
		CCITT(2),
		PACKBITS(32773);
		
		private Tag tag;
		public static Map<Integer, Tag> iToTag = Collections.unmodifiableMap(buildMap(Compression.values()));
		private Compression(int value) {
			tag = new TagImpl(value);
		}
		public int getValue() {
		    return tag.getValue();
		}
	}
	
	public enum PhotometricInterpretation implements Tag{
		WHITE_IS_ZERO(0),
		BLACK_IS_ZERO(1),
		RGB(2),
		PALETTE(3),
		TRANSPARENCY_MASK(4);
		
		private Tag tag;
		public static Map<Integer, Tag> iToTag = Collections.unmodifiableMap(buildMap(Compression.values()));
		private PhotometricInterpretation(int value) {
			tag = new TagImpl(value);
		}
		public int getValue() {
		    return tag.getValue();
		}
	}
	
	public enum PlanarConfiguration implements Tag{
		CHUNKY(1),
		PLANAR(2);
		
		private Tag tag;
		public static Map<Integer, Tag> iToTag = Collections.unmodifiableMap(buildMap(Compression.values()));
		private PlanarConfiguration(int value) {
			tag = new TagImpl(value);
		}
		public int getValue() {
		    return tag.getValue();
		}
	}
	
	static Map<Integer,Tag> buildMap(Tag[] tagEntry){
		HashMap<Integer, Tag> iToTag = new HashMap<Integer, Tag>();
		for(Tag t : tagEntry) {
			iToTag.put(t.getValue(), t);
		}
		return iToTag;
	}
}

