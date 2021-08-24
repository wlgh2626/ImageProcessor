package com.project.image;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import com.project.image.files.tiff.IFD.tags.TagEntry.*;

public class TagTest {
	@Test
	public void simpleTagsTest() throws Exception {
		assertEquals(Compression.iToTag.get(1) , Compression.NONE);	
		assertEquals(Compression.iToTag.get(2).getValue() , 2);
	}
}
