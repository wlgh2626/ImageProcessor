package com.project.image.tiff.IFD.tags;

public class TagsEntry {
	enum Compression{
		NONE(1),
		CCITT(2),
		PACKBITS(32773);
		
		private int value;
		private Compression(int value) {
			this.value = value;
		}
		public int getValue() {
		    return value;
		}
	}
	
	enum PhotometricInterpretation{
		WHITE_IS_ZERO(0),
		BLACK_IS_ZERO(1),
		RGB(2),
		PALETTE(3),
		TRANSPARENCY_MASK(4);
		
		private int value;
		private PhotometricInterpretation(int value) {
			this.value = value;
		}
		public int getValue() {
		    return value;
		}
	}
	
	enum PlanarConfiguration{
		CHUNKY(1),
		PLANAR(2);
		private int value;
		private PlanarConfiguration(int value) {
			this.value = value;
		}
		public int getValue() {
		    return value;
		}
	}
}
