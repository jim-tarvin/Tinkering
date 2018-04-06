package com.ramfam.RotateMatrix;

public class Main {

	public static void main( String[] args ) {

		int N = 7;

		int[][] a = make(N);
		print( a, N );

		System.out.println("-----");

		Rotate.doIt( a, N );
		print( a, N );

	}


	static int[][] make( int size ) {

		int[][] out = new int[size][size];
		int count = 1;

		for ( int row = 0 ; row < size ; row++ ) {

			for ( int col = 0 ; col < size ; col++ ) {

				out[row][col] = count++;
			}

		}

		return out;
	}

	static void print( int[][] array, int size ) {

		for ( int row = 0 ; row < size ; row++ ) {

			System.out.print("{ ");
			for ( int col = 0 ; col < size ; col++ ) {

				System.out.printf("%3d ", array[row][col] );
			}

			System.out.println("}");
		}

	}

}
