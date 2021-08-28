package com.project.image.files.tiff;

import java.util.ArrayList;
import java.util.Arrays;

import com.project.image.files.tiff.ifd.ImageFileDirectory;
import com.project.image.files.tiff.ifd.TagNames.TagName;
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

		ImageFileDirectory currentIFD;
		Image currentImage;
		do {
			currentIFD = new ImageFileDirectory(data, header.getOffset(), header.getBufferReader());
			currentImage = new Image.ImageBuilder().length(currentIFD.tagToValue(TagName.IMAGE_LENGTH).get(0))
					.width(currentIFD.tagToValue(TagName.IMAGE_LENGTH).get(0)).build();

			ifdList.add(currentIFD);
			imageList.add(currentImage);
		} while (currentIFD.getNextOffset() != 0);

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
