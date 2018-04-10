package com.ramfam.Matrix.RotateMatrix;

public class Main {

	public static void main( String[] args ) {

		int N = 7;

		int[][] a = make(N);
		print( a, N );

		System.out.println("-----");

		rotate( a, N );
		print( a, N );

	}

	static int[][] rotate(int[][] array, int size ) {

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
