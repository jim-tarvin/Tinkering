package com.ramfam.LinkedList.Reverse;

public class MyList {

	class Node {

		int value;
		Node next;

		Node( int value ) {
			this.value = value;
		}
	}

	Node head;

	void reverse( int k ) {
		head = reverse( head, k );
	}

	private Node reverse( Node head, int k ) {

		Node current = head;
		Node next = null;
		Node prev = null;


//		for ( int count = 0 ; count < k && current != null ; count++ ) {
//			next = current.next;
//		}

		int count = 0;
		while ( count < k  && current != null ) {

			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		if ( next != null )
			head.next = reverse( next, k );

		return prev;
	}

	void push( int value ) {
		Node n = new Node(value);
		n.next = head;
		head = n;
	}

	void print() {
		Node current = head;
		while ( current != null ) {
			System.out.print( current.value + " ");
			current = current.next;
		}
		System.out.println();
	}
}
