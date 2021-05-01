package com.project.image;

import static org.junit.Assert.*;

import org.junit.Test;

import com.project.image.matrix.Matrix;
public class MatrixTest {
	double[][] unevenMatrix = {
			{1,2,3,4,5},
			{2,4,5,6,1},
			{10,14,15,16,17},
	};
	
	double[][] evenMatrix = {
			{1,2,3,4,5},
			{2,4,5,6,1},
			{10,14,15,16,17},
			{8,6,2,3,6},
			{15,18,21,14,41},
	};
	@Test
	public void matrixTest() {
		Matrix matrix = new Matrix(5,5);
	}
	
	

}
