package com.ramfam.Trees.TreeTraversals;

public class Node {

	static int nextId = 1;

	public int value;

	public Node left;
	public Node right;

	public Node() {
		this.value = nextId++;
	}

	public Node( int value ) {
		this.value = value;
	}

}
