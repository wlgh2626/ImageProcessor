package com.project.image.matrix;

import org.apache.commons.math3.linear.RealMatrix;

//Apache real matrix wrapper
public class Matrix {
	RealMatrix matrix = null;

	public Matrix(int rowDimension, int colDimension) {
		matrix.createMatrix(rowDimension, colDimension);
	}

	public void setData(double[][] data) {
		matrix.setSubMatrix(data, data.length, data[0].length);
	}

	public void setData(double data, int row, int col) {
		matrix.setEntry(row, col, data);
	}

	public double[][] getData() {
		return matrix.getData();
	}

}
