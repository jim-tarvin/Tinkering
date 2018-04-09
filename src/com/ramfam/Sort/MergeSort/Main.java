package com.ramfam.Sort.MergeSort;

import com.ramfam.Util.Print;

import java.util.Arrays;

public class Main {

	public static void main( String[] args ) {

		int[] data = { 1, 9, 33, 6, 19385, 283, 28, 48120, 232, 93 };

		System.out.println(Arrays.toString(data));

		prep( data.length );
		sort( data, 0, data.length - 1);

		System.out.println(Arrays.toString(data));

	}

	static int[] L;
	static int[] R;
	static void prep( int size ) {

		L = new int[(size/2)+1];
		R = new int[(size/2)+1];
	}

	static void merge( int[] data, int left, int mid, int right ) {

		int leftSize = mid - left + 1;
		int rightSize = right - mid;
		Print.enter("Merge ("+leftSize+","+rightSize+")");


		// put the data into two separate temp arrays
		Print.note("Create Temp arrays ("+leftSize+","+rightSize+")");
//		int[] L = new int[leftSize];
//		int[] R = new int[rightSize];

		for ( int i = 0 ; i < leftSize ; i++ ) {
			L[i] = data[ left + i ];
		}

		for ( int j = 0 ; j < rightSize ; j++ ) {
			R[j] = data[ mid + 1 + j ];
		}


		// merge the two temp arrays back into the original array
		// i controls the position in the 'left' array, j in the right,
		//	and k in the target array

		int i = 0, j = 0, k = left;

		while ( i < leftSize && j < rightSize ) {

			if ( L[i] <= R[j] ) {

				data[k] = L[i++];

			} else {

				data[k] = R[j++];

			}

			k++;
		}

		// copy remaining elements
		while ( i < leftSize ) {

			data[k++] = L[i++];

		}

		while ( j < rightSize ) {

			data[k++] = R[j++];

		}
		Print.exit("Merge ("+leftSize+","+rightSize+")");
	}

	static void sort( int[] data, int left, int right ) {

		Print.enter("Sort ("+left+","+right+")");
		if ( left < right ) {

			int mid = (left + right) / 2;

			Print.note("Sort left ("+left+","+mid+")");
			sort( data, left, mid );
			Print.note("Sort right ("+mid+","+right+")");
			sort( data, mid+1, right );

			merge( data, left, mid, right );
		}
		Print.exit("Sort ("+left+","+right+")");
	}
}
