package com.ramfam.Misc.Triplet;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

    	int[] work1 = new int[] { 1, 5, 7, 3, 12, 14, 19, 22, 8, 6, 4, 13 };

    	hasPythagoreanTriplet( work1 );

    }



    static void hasPythagoreanTriplet( int[] array ) {

    	Arrays.sort( array );
    	int count = array.length;

		System.out.print("[");
    	for ( int i = 0 ; i < count ; i++ ) {
			System.out.print( array[i] + "\t" );
		}
		System.out.println("]");

    	// square everything
		for ( int i = 0 ; i < count ; i++ ) {
			array[i] *= array[i];
		}

		System.out.print("[");
		for ( int i = 0 ; i < count ; i++ ) {
			System.out.print( array[i] + "\t" );
		}
		System.out.println("]");

		// start end the end of the array and work backward to the first element in the array
		// for all array entries LOWER than the current position, have an index in the first (zero'th) position
		// and an index in the current position - 1;  add them up to see if they equal the current position


		for ( int c = count - 1 ; c >= 2 ; c-- ) {

			int a = 0;
			int b = c - 1;
			int value;

			while ( a < b ) {

				System.out.print("a^2 = " + array[a] + "  b^2 = " + array[b] + "  c^2 = " + array[c] );
				value = array[a] + array[b];

				if ( value == array[c] )
					System.out.println(" --- MATCH");
				else
					System.out.println();

				// move only one index

				if ( value < array[c] ) {
					a++;
				} else {
					b--;
				}
			}
		}
	}
}
