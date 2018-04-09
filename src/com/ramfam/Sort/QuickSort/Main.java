package com.ramfam.Sort.QuickSort;

import com.ramfam.Util.Print;

import java.util.Arrays;

public class Main {

	static public void main( String[] args ) {

		int[] data = { 1, 75, 9, 4, 33, 6, 19385, 283, 5, 48120, 232, 93 };

		System.out.println(Arrays.toString(data));

		sort( data, 0, data.length - 1);

		System.out.println(Arrays.toString(data));


	}


	static void sort( int[] data, int left, int right ) {

		Print.enter("Sort ("+left+","+right+")");
		int index = partition( data, left, right );

		if ( left < index - 1 ) {
			Print.note("sort left");
			sort(data, left, index - 1);
		}

		if ( index < right ) {
			Print.note("sort right");
			sort( data, index, right );
		}
		Print.exit("Sort ("+left+","+right+")");
	}

	static int partition( int[] data, int left, int right ) {

		int pivot = data[(left+right)/2];
		int temp;
		Print.enter("partition ("+left+","+right+")  pivot is data["+((left+right)/2)+"]="+pivot);

		while ( left < right ) {

			Print.note("While loop("+left+","+right+")");
			while ( data[left] < pivot ) {
				left++;
			}

			while (data[right] > pivot ) {
				right--;
			}

			Print.bump("While loop compare("+left+","+right+")");
			if ( left <= right ) {
				Print.bump("Swap elements("+left+","+right+") "+Arrays.toString(data));
				temp = data[left];
				data[left] = data[right];
				data[right] = temp;
				Print.bump("After swap   ("+left+","+right+") "+Arrays.toString(data));
				left++;
				right--;
			}
		}

		Print.exit("partition ("+left+","+right+")");
		return left;
	}
}
