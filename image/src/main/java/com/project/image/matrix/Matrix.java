package com.project.image.matrix;

import java.util.stream.IntStream;

import org.apache.commons.math3.linear.RealMatrix;

//Was originally going to be Generic Matrix, but Java makes it hard.
//Wrap Apache real matrix instead
public class Matrix{
	RealMatrix matrix = null;
	public Matrix(int rowDimension , int colDimension) {
		matrix.createMatrix(rowDimension , colDimension);
	}
	
	public double[][] getData() {
		return matrix.getData();
	}
	
}
