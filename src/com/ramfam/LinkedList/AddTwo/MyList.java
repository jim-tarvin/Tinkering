package com.ramfam.LinkedList.AddTwo;

public class MyList {

	Node head;
	Node tail;

	void add( int value ) {

		Node n = new Node(value);

		if ( head == null ) {
			head = tail = n;
			return;
		}

		if ( head == tail ) {
			head.next = n;
			tail = n;
			return;
		}

		tail.next = n;
		tail = n;
	}

	void print() {

		Node c = head;

		System.out.print("[");

		while ( c != null ) {
			System.out.print( c.value + " " );
			c = c.next;
		}

		System.out.println("]");
	}
}
