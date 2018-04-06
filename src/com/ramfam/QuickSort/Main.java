package com.ramfam.QuickSort;

import java.util.Arrays;

public class Main {

	static public void main( String[] args ) {

		int[] data = { 1, 75, 9, 4, 33, 6, 19385, 283, 28, 48120, 232, 93 };

		System.out.println(Arrays.toString(data));

		sort( data, 0, data.length - 1);

		System.out.println(Arrays.toString(data));


	}


	static void sort( int[] data, int left, int right ) {

		int index = partition( data, left, right );

		if ( left < index - 1 ) {
			sort(data, left, index - 1);
		}

		if ( index < right ) {
			sort( data, index, right );
		}
	}

	static int partition( int[] data, int left, int right ) {

		int pivot = data[(left+right)/2];
		int temp;

		while ( left <= right ) {

			while ( data[left] < pivot ) {
				left++;
			}

			while (data[right] > pivot ) {
				right--;
			}

			if ( left <= right ) {
				temp = data[left];
				data[left] = data[right];
				data[right] = temp;
				left++;
				right--;
			}
		}

		return left;
	}
}
