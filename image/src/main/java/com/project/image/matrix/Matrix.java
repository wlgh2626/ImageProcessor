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
	
	public void setData(double[][] data) {
		matrix.setSubMatrix(data, data.length, data[0].length);
	}
	
	public void setData(double data, int row , int col) {
		matrix.setEntry( row, col, data);
	}
	
	public double[][] getData() {
		return matrix.getData();
	}
	
}
