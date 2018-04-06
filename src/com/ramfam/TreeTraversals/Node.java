package com.ramfam.TreeTraversals;

class Node {

	static int nextId = 1;

	int value;

	Node left;
	Node right;

	public Node() {
		this.value = nextId++;
	}

	public Node( int value ) {
		this.value = value;
	}

}
