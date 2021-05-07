package com.project.image;
import static org.junit.Assert.*;

import org.junit.Test;

import com.project.image.files.ByteBuffer;
import com.project.image.files.Properties.FileType;
import com.project.image.files.tiff.header.Header;
public class HeaderTest {
	byte[] balloonsHeader = {
		0x49 , 0x49, 0x2A, 0x00, 0x08, 0x10, 0x05, 0x00
	};
	
	@Test
	public void simpleHeaderTest() throws Exception {
		ByteBuffer buffer = new ByteBuffer(new byte[] {0x49,0x49});
		Header header = new Header(balloonsHeader,buffer);
		assertEquals(header.getFileType(), FileType.TIFF);
		assertEquals(header.getOffSet().intValue() , 331784);
	}
}
