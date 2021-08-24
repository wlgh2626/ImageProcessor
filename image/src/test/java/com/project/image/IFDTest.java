package com.project.image;

import java.io.File;
import java.nio.file.Files;

import org.junit.Test;

import com.project.image.files.tiff.Tiff;

public class IFDTest {
	File balloonsFile = new File(Tiff.TIFF_DIRECTORY + "/balloons.tif");
	File autumnFile = new File(Tiff.TIFF_DIRECTORY + "/autumn.tif");
	File boardFile = new File(Tiff.TIFF_DIRECTORY + "/board.tif");
	File brainFile = new File(Tiff.TIFF_DIRECTORY + "/brain.tif");
	File columnsFile = new File(Tiff.TIFF_DIRECTORY + "/columns.tif");
	File lenaFile = new File(Tiff.TIFF_DIRECTORY + "/lena.tif");

	@Test
	public void balloonsIFDTest() throws Exception {
		byte[] balloonsData = Files.readAllBytes(columnsFile.toPath());
		Tiff tiff = new Tiff(balloonsData);

	}
}
