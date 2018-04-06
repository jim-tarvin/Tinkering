package com.ramfam.Reverse;


import com.ramfam.Stack.MyStack;

public class Main {

	public static void main( String[] args ) {

		MyList ml = new MyList();

		ml.push( 9 );
		ml.push( 8 );
		ml.push( 7 );
		ml.push( 6 );
		ml.push( 5 );
		ml.push( 4 );
		ml.push( 3 );
		ml.push( 2 );
		ml.push( 1 );

		ml.print();

		ml.reverse(2 );

		ml.print();
	}

}