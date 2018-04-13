package com.ramfam.Trees.BinaryTree;

import com.ramfam.Trees.TreeTraversals.DoIt;
import com.ramfam.Trees.TreeTraversals.Node;

import static com.ramfam.Trees.TreeTraversals.DoIt.nodePrinter;

public class Main {

	public static void main( String[] args ) {

		int[] data = { 286, 1, 75, 9, 4, 33, 6, 6, 19385, 283, 28, 48120, 232, 93 };

		BTree tree = new BTree();
		Node root = new Node(data[0]);

		for ( int i = 1 ; i < data.length ; i++ ) {
			tree.insert(root,data[i]);
		}
		System.out.println("isBST ? " + tree.isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE));

		DoIt doIt = new DoIt();
		doIt.go( root );


		System.out.print("Nodes:: ");
		doIt.inOrder( root, nodePrinter );
		System.out.println();

	}
}
