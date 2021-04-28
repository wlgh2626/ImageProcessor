package com.project.image.matrix;

import java.util.stream.IntStream;

//Was originally going to be Generic Matrix, but Java makes it hard.
public class Matrix{
	double[][] elements;
	int rowSize;
	int colSize;
	
	public Matrix(double[][] matrix) {
		elements = matrix;
	}
	
	public Matrix(int[][] matrix) {
		//convert to doubles
	}
	
	@SuppressWarnings("unchecked")
	public Matrix(int x , int y) {
		rowSize = x;
		colSize = y;
		elements =  new double[rowSize][colSize];
	}
	
	public void setRowMatrix(double[] rowData, int rowIndex) {
		if(elements.length == rowData.length) {
			elements[rowIndex] = rowData;
		}
	}
	
	public void setColMatrix(double[] colData, int colIndex) {
		if(elements[0].length == colData.length) {
			IntStream.range(0, rowSize).forEach(i-> elements[i][colIndex] = colData[i]);
		}
		
	}
	
	public void setElementAt(double value, int rowIndex, int colIndex) {
		elements[rowIndex][colIndex] = value;
	}
	
	public double getElementAt(int rowIndex, int colIndex) {
		return elements[rowIndex][colIndex];
	}
	
	public double[] getRowMatrix(int rowIndex) {
		return elements[rowIndex];
	}
	
	public double[] getColMatrix(int colIndex) {
		return elements[colIndex];
	}
	
	public int getRowSize() {
		return rowSize;
	}
	
	public int getColSize() {
		return colSize;
	}
	
}
