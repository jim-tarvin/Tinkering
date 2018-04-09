package com.ramfam.Arrays.BinarySearch;

import java.util.Arrays;

public class Main {

	public static void main( String[] args ) {


		int[] values = {
			1, 992, 293, 1084, 5, 87, 283, 6, 99,
				109, 37392, 5, 892, 312, 287, 50, 29,
		};

//		Arrays.sort(values);

		sort(values);

		int find = 892;
		int pos = search( values, 0, values.length-1, find );

		System.out.println("Find " + find + " in " + Arrays.toString(values) + " returns " + pos );

	}


	static int search( int array[], int left, int right, int value  ) {

		if ( right >= left ) {

			int mid = (right + left) / 2 ;

			if ( array[mid] == value )
				return mid;

			if ( array[mid] > value )
				return search( array, left, mid-1, value );
			else
				return search( array, mid+1, right, value );
		}

		return -1;
	}

	static void sort(int[] array ) {

		int len = array.length;

		for ( int i = 1 ; i < len ; i++ ) {

			int val = array[i];		// value to (possibly) move
			int j = i - 1;			// compare from 0..(i-1)

			while ( j >= 0 && array[j] > val ) {

				array[j+1] = array[j];
				j--;
			}

			array[j+1] = val;

		}
	}
}
