package com.ramfam.Matrix.RotateMatrix;

public class Rotate {

	static int[][] doIt( int[][] array, int size ) {

		for ( int x = 0 ; x < size/2 ; x++ ) {

			for ( int y = x ; y < size-x-1 ; y++ ) {

				int temp = array[x][y];

				array[x][y] = array[y][size-1-x];

				array[y][size-1-x] = array[size-1-x][size-1-y];

				array[size-1-x][size-1-y] = array[size-1-y][x];

				array[size-1-y][x] = temp;
			}

		}

		return array;
	}
}