package com.ramfam.Sort.HeapSort;

import com.ramfam.Util.Print;

import java.util.Arrays;

public class Main {

	public static void main( String[] args ) {

		int[] data = { 1, 75, 9, 4, 33, 6, 19385, 283, 28, 48120, 232, 93 };

		System.out.println(Arrays.toString(data));

		sort( data );

		System.out.println(Arrays.toString(data));

	}


	static void sort( int[] data ) {

		int size = data.length;


		// create max heap
		Print.enter("Begin creating max heap " + Arrays.toString(data) );
		for ( int i = size / 2 - 1 ; i >= 0 ; i-- ) {
			Print.note("call heapify, i="+i);
			heapify(data,size,i);
		}
		Print.note("After creating max heap " + Arrays.toString(data) );
		Print.note("--------");
		Print.note("--------");

		Print.note( "enter sorting loop" );
		for ( int i = size - 1 ; i >= 0 ; i-- ) {	// all elements greater than 'i' are known to be sorted
			Print.note( "Loop iteration " + i + "  Swap element " + 0 + " and " + i );
			swap( data, 0, i );					// swap first and last element
			Print.note("Post swap of element " + i + "  " + Arrays.toString(data) );
			heapify( data, i, 0 );				// re-build max heap
			Print.note("Post heapify  " + Arrays.toString(data) );
			Print.note("--------");
		}
		Print.exit("");
	}


	static void heapify( int data[], int size, int root ) {

		Print.enter("heapify size="+size+",  root="+root);
		int posOfLargest = root;
		int left  = 2*root + 1;
		int right = 2*root + 2;

		if ( left < size && data[left] > data[posOfLargest] ) {
			posOfLargest = left;
		}

		if ( right < size && data[right] > data[posOfLargest] ) {
			posOfLargest = right;
		}

		if ( posOfLargest != root ) {
			Print.start( "Swap element " + root + " and " + posOfLargest + "  :::::: "  );
			swap( data, root, posOfLargest );
			Print.note( Arrays.toString(data) );
			heapify( data, size, posOfLargest );
		}
		Print.exit("");
	}


	static void swap( int[] data, int left, int right ) {
		int t = data[left];
		data[left] = data[right];
		data[right] = t;
	}
}
