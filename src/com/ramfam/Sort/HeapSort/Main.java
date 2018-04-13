package com.ramfam.Sort.HeapSort;


import java.util.Arrays;

public class Main {

	public static void main( String[] args ) {

		int[] data = { 1, 75, 9, 4, 33, 6, 19385, 283, 28, 48120, 232, 93 };

		System.out.println(Arrays.toString(data));

		sort( data, new MinHeap() );

		System.out.println(Arrays.toString(data));

	}


	static void sort( int[] data, Heap heap ) {

		int size = data.length;

		// we treat the data array as a complete binary tree
		// 'size / 2 - 1' gives us the position of the last non-leaf node in the complete binary tree
		// we use this to visit every non-leaf node in the tree from lowest and right-most to the top-most.
		//		(i.e. (size / 2 - 1) ... 0)
		//
		//	this has the effect of bubbling the largest number up to the 'top' of the complete binary tree (aka data[0])

		// create max heap
		for ( int i = size / 2 - 1 ; i >= 0 ; i-- ) {
			heap.heapify(data,size,i);
		}

		// Because we know that we are working with a max heap, the first element will be the largest
		//	so...we swap the first and last element to place the largest value in the last element of the array
		//	then...we heapify the remaining elements which once again places the largest remaining element in
		//			the first position of the array...and so on

		for ( int i = size - 1 ; i >= 0 ; i-- ) {	// all elements greater than 'i' are known to be sorted
			swap( data, 0, i );					// swap first and last element (beca
			heap.heapify( data, i, 0 );				// re-build max heap
		}
	}


	static void heapify( int data[], int size, int root ) {

		/**
		 * for the given root node, find the largest value of the root and its left
		 * and right child.
		 * swap the root value with the largest value.  This will mean that the root node will
		 * have the largest value of the three
		 */
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
			swap( data, root, posOfLargest );		// make the root the largest
			heapify( data, size, posOfLargest );	// now, we've modified the child, so we have to check it
		}
	}

	interface Heap {
		public void heapify( int[] data, int size, int root );
	}

	static class MaxHeap implements Heap {
		@Override
		public void heapify(int[] data, int size, int root) {
			/**
			 * for the given root node, find the largest value of the root and its left
			 * and right child.
			 * swap the root value with the largest value.  This will mean that the root node will
			 * have the largest value of the three
			 */
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
				swap( data, root, posOfLargest );		// make the root the largest
				heapify( data, size, posOfLargest );	// now, we've modified the child, so we have to check it
			}

		}
	}

	static class MinHeap implements Heap {
		@Override
		public void heapify(int[] data, int size, int root) {
			/**
			 * for the given root node, find the largest value of the root and its left
			 * and right child.
			 * swap the root value with the largest value.  This will mean that the root node will
			 * have the largest value of the three
			 */
			int posOfLargest = root;
			int left  = 2*root + 1;
			int right = 2*root + 2;

			if ( left < size && data[left] < data[posOfLargest] ) {
				posOfLargest = left;
			}

			if ( right < size && data[right] < data[posOfLargest] ) {
				posOfLargest = right;
			}

			if ( posOfLargest != root ) {
				swap( data, root, posOfLargest );		// make the root the largest
				heapify( data, size, posOfLargest );	// now, we've modified the child, so we have to check it
			}

		}
	}

	static void swap( int[] data, int left, int right ) {
		int t = data[left];
		data[left] = data[right];
		data[right] = t;
	}
}
