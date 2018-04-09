package com.ramfam.LinkedList.AddTwo;

public class Main {

	public static void main( String[] args ) {

		MyList ml = new MyList();

		ml.add( 3 );
		ml.add( 6 );
		ml.add( 9 );
		ml.add( 6 );
		ml.add( 3 );

		ml.print();

		MyList ml2 = new MyList();

		ml2.add( 7 );
		ml2.add( 4 );

		ml2.print();

		sum( ml.head, ml2.head );

		print( addTwo(ml.head, ml2.head) );
	}

	static void sum( Node left, Node right ) {

		int power = 1;
		int sum = 0;

		while ( left != null || right != null ) {

			int lval = (left  != null ? left .value : 0) * power;
			int rval = (right != null ? right.value : 0) * power;

			sum += lval + rval;
			power *= 10;

			if ( left != null ) left = left.next;
			if ( right != null ) right = right.next;
		}

		System.out.println( "sum = " + sum );
	}

	static Node addTwo( Node left, Node right ) {

		Node out = null;
		Node prev = null;
		Node temp = null;

		int carry = 0;
		int sum = 0;

		while ( left != null || right != null ) {

			int first = left != null ? left.value : 0;
			int second = right != null ? right.value : 0;
			sum = carry + first + second;

			// reset carry based on new sum
			carry = sum > 9 ? 1 : 0;	// carry 1 (can't be more than 1)

			// if sum is greater than 10, 'remove' the carry
			sum %= 10;

			temp = new Node(sum);

			if ( out == null ) {	// first node?
				out = temp;
			} else {
				prev.next = temp;
			}

			prev = temp;

			if ( left != null ) left = left.next;
			if ( right != null ) right = right.next;

		}

		// don't forget the carry!
		if ( carry > 0 )
				temp.next = new Node(carry);

		return out;
	}

	static void print(Node c) {

		System.out.print("[");

		while ( c != null ) {
			System.out.print( c.value + " " );
			c = c.next;
		}

		System.out.println("]");
	}

}
