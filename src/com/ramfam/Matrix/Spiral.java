package com.ramfam.Matrix;

public class Spiral {


	public static void main (String[] args)
	{
		int R = 3;
		int C = 6;
		int a[][] =
		{
				{ 1,  2,  3,  4,  5,  6},
				{ 7,  8,  9, 10, 11, 12},
				{13, 14, 15, 16, 17, 18}
		};
		spiralPrint(R,C,a);
	}


	// Function print matrix in spiral form
	static void spiralPrint(int lastRow, int lastCol, int[][] data)
	{
		int i, startRow = 0, startCol = 0;

		while ( startRow < lastRow && startCol < lastCol )
		{
			// Print the first lastRow from the remaining rows
			printRow( data, startRow++, startCol, lastCol );
//			for ( i = startCol; i < lastCol; ++i )
//			{
//				System.out.print(data[startRow][i]+" ");
//			}
//			startRow++;

			// Print the last column from the remaining columns
			printCol( data, lastCol-1, startRow, lastRow );
			lastCol--;	// pull the last column 'in' by one
//			for (i = startRow; i < lastRow; ++i)
//			{
//				System.out.print(data[i][lastCol-1]+" ");
//			}
//			lastCol--;

			// Print the last lastRow from the remaining rows */
			if ( startRow < lastRow)
			{
				for (i = lastCol-1; i >= startCol; --i)
				{
					System.out.print(data[lastRow-1][i]+" ");
				}
				lastRow--;
			}

			// Print the first column from the remaining columns */
			if (startCol < lastCol)
			{
				for (i = lastRow-1; i >= startRow; --i)
				{
					System.out.print(data[i][startCol]+" ");
				}
				startCol++;
			}
		}
	}

	static void printRow( int[][] data, int row, int start, int end ) {

		for ( int i = start ; i < end ; i++ ) {

			System.out.print( data[row][i] + " " );
		}
	}

	static void printCol( int[][] data, int col, int start, int end ) {

		for ( int i = start ; i < end ; i++ ) {

			System.out.print( data[i][col] + " " );
		}
	}

}
