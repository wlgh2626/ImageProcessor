package com.project.image;

import java.io.File;
import java.nio.file.Files;
import org.junit.Test;

import com.project.image.files.tiff.IFD.tags.*;
import com.project.image.files.tiff.Tiff;

public class IFDTest {
	File balloonsFile = new File(System.getProperty("user.dir") + "/tiff/balloons.tif");
	
	@Test
	public void balloonsIFDTest() throws Exception {
		byte[] balloonsData = Files.readAllBytes(balloonsFile.toPath());
		Tiff tiff= new Tiff(balloonsData);
		for(Entry entry : tiff.getIFD().getEntryList()) {
			System.out.println(entry.toString());
		}
		System.out.println("Next IFD Offset: " + tiff.getIFD().getNextOffset());
	}
}
