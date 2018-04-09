package com.ramfam.Sort.BubbleSort;

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
		int count = 1;

		for ( int i = 0 ; i < n - 1 && count > 0 ; i++ ) {

			count = 0;

			for ( int j = 0 ; j < n - i - 1 ; j++ ) {

				if ( data[j] > data[j+1] ) {

					count++;
					t = data[j];
					data[j] = data[j+1];
					data[j+1] = t;
				}
			}
		}
	}

}
