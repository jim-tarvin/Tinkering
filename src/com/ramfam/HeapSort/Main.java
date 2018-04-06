package com.ramfam.HeapSort;

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

		Print.note("Build heap" );
		for ( int i = size / 2 - 1 ; i >= 0 ; i-- ) {
			heapify(data,size,i);
		}

		Print.note( "After: " + Arrays.toString(data) );

		int temp;
		for ( int i = size - 1 ; i >= 0 ; i-- ) {
			Print.bump("Swap ["+data[0]+","+data[i]+"  "+Arrays.toString(data));
			temp = data[0];
			data[0] = data[i];
			data[i] = temp;
			Print.bump("Post ["+data[0]+","+data[i]+"  "+Arrays.toString(data));

			heapify( data, i, 0 );
		}
	}

	static void heapify( int data[], int size, int root ) {

		Print.enter("heapify("+size+","+root+")");
		int largest = root;
		int left  = 2*root + 1;
		int right = 2*root + 2;

		Print.note("left="+left+",  right="+right);
		if ( left < size && data[left] > data[largest] ) {
			largest = left;
		}

		if ( right < size && data[right] > data[largest] ) {
			largest = right;
		}

		if ( largest != root ) {
			int temp = data[root];
			data[root] = data[largest];
			data[largest] = temp;

			heapify( data, size, largest );
		}
		Print.exit("heapify("+size+","+root+")");
	}
}
