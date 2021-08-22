package com.project.image;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;

import org.junit.Test;

import com.project.image.files.ByteBufferReader;
import com.project.image.files.Convert;
import com.project.image.files.ByteBufferReader.ByteOrder;
import com.project.image.files.Properties.FileType;
import com.project.image.files.tiff.Header;
import com.project.image.files.tiff.ImageFileDirectory;
import com.project.image.files.tiff.ImageFileDirectory.Entry;
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
	}
}
