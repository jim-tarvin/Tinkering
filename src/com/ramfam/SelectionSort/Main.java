package com.ramfam.SelectionSort;

import java.util.Arrays;

public class Main {

	public static void main( String[] args ) {

		int[] data = { 1, 75, 9, 4, 33, 6, 19385, 283, 28, 48120, 232, 93 };

		System.out.println(Arrays.toString(data));

		sort( data );

		System.out.println(Arrays.toString(data));

	}

	static void sort( int[] data ) {

		int n = data.length;
		int t;

		for ( int i = 0 ; i < n-1 ; i++ ) {

			int minPos = i;

			for ( int j = i+1 ; j < n ; j++ ) {

				if ( data[j] < data[minPos] )
					minPos = j;
			}

			t = data[minPos];
			data[minPos] = data[i];
			data[i] = t;
		}
	}

}
