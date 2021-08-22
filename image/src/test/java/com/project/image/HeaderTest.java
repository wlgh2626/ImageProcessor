package com.project.image;
import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;

import org.junit.Test;

import com.project.image.files.ByteBufferReader;
import com.project.image.files.ByteBufferReader.ByteOrder;
import com.project.image.files.Properties.FileType;
import com.project.image.files.tiff.Header;
public class HeaderTest {
	File balloonsFile = new File(System.getProperty("user.dir") + "/tiff/balloons.tif");
	byte[] balloonsHeader = {
		0x49 , 0x49, 0x2A, 0x00, 0x08, 0x10, 0x05, 0x00
	};
	
	@Test
	public void simpleHeaderTest() throws Exception {
		Header header = new Header(balloonsHeader);
		assertEquals(header.getFileType(), FileType.TIFF);
		assertEquals(header.getByteOrder() , ByteOrder.LITTLE_ENDIAN);
		assertEquals(header.getOffset().intValue() , 331784);
		System.out.println(header.toString());
	}
	
	@Test
	public void balloonsHeaderTest() throws Exception {
		byte[] balloonsData = Files.readAllBytes(balloonsFile.toPath());
		Header header = new Header(Arrays.copyOfRange(balloonsData, 0, 8));
		assertEquals(header.getFileType(), FileType.TIFF);
		assertEquals(header.getByteOrder() , ByteOrder.LITTLE_ENDIAN);
		assertEquals(header.getOffset().intValue() , 331784);
		System.out.println(header.toString());
	}
}
