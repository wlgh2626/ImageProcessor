package com.project.image.files.tiff;

import java.util.ArrayList;
import java.util.Arrays;

import com.project.image.files.tiff.header.Header;
import com.project.image.files.tiff.ifd.ImageFileDirectory;
import com.project.image.files.tiff.ifd.Tags.TagName;
import com.project.image.files.tiff.image.Image;

public class Tiff {
	public static final String TIFF_DIRECTORY = System.getProperty("user.dir") + "/tiff";
	private Header header;
	private ArrayList<Image> imageList = new ArrayList<Image>();
	private ArrayList<ImageFileDirectory> ifdList = new ArrayList<ImageFileDirectory>();
	private final byte[] data;

	public Tiff(byte[] data) throws Exception {
		this.data = data;
		header = new Header(Arrays.copyOfRange(data, 0, 8));
		int currentOffset = header.getOffset();
		
		ImageFileDirectory currentIFD;
		Image currentImage;
		do {
			currentIFD = new ImageFileDirectory(data, currentOffset, header.getBufferReader());
			currentImage = new Image.Builder(data)
								.length(currentIFD.tagToValue(TagName.IMAGE_LENGTH).get(0))
								.width(currentIFD.tagToValue(TagName.IMAGE_WIDTH).get(0))
								.byteCounts(currentIFD.tagToValue(TagName.STRIP_BYTE_COUNTS))
								.offsets(currentIFD.tagToValue(TagName.STRIPS_OFF_SETS))
								.build();

			ifdList.add(currentIFD);
			imageList.add(currentImage);
			currentOffset = currentIFD.getNextOffset();
		} while (currentOffset != 0);

	}

	public Header getHeader() {
		return header;
	}

	public ArrayList<ImageFileDirectory> getIFDList() {
		return ifdList;
	}

	public ArrayList<Image> getImageList() {
		return imageList;
	}

}
