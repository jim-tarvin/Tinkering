package com.ramfam.Trees.BinaryTree;

import com.ramfam.Trees.TreeTraversals.Node;

public class BTree {

	public Node insert( Node n, int value ) {

		if ( n == null )
			return new Node( value );


		if ( value < n.value ) {

			n.left = insert( n.left, value );

		} else if ( value > n.value ) {

			n.right = insert( n.right, value );

		}

		return n;
	}

	public boolean isBST( Node n, int min, int max ) {

		if ( n == null ) {
			return true;
		}

		if ( n.value < min || n.value > max ) {
			return false;
		}

		return isBST( n.left, min, n.value-1 ) || isBST( n.right, n.value+1, max );
	}
}
