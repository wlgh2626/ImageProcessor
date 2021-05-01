package com.project.image;
import static org.junit.Assert.*;



import org.junit.Test;

import com.project.image.properties.Properties.ByteOrder;
import com.project.image.properties.Properties.FileType;
import com.project.image.tiff.header.Header;
public class HeaderTest {
	byte[] balloonsHeader = {
		0x49 , 0x49, 0x2A, 0x00, 0x08, 0x10, 0x05, 0x00
	};
	
	@Test
	public void simpleHeaderTest() throws Exception {
		Header header = new Header(balloonsHeader);
		assertEquals(header.getFileType(), FileType.TIFF);
		assertEquals(header.getByteOrder(), ByteOrder.LITTLE_ENDIAN);
		assertEquals(header.getOffSet().intValue() , 331784);
	}
}
