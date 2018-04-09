package com.ramfam.Trees.TreeTraversals;

import java.util.LinkedList;
import java.util.Queue;

public class DoIt {

	Node head;
	static Node prev = null;

	public void go(Node root) {

		System.out.println("fun = " + fun(root));
		System.out.println("max = " + maxDepth(root));

		SumAction sa = new SumAction();
		inOrder(root, sa);
		System.out.println("sum = " + sa.total);

		System.out.println("======");


		System.out.print("Pre Order\t\t\t\t\t[");
		preOrder(root, printer);
		System.out.println("]");

		System.out.print("In Order\t\t\t\t\t[");
		inOrder(root, printer);
		System.out.println("]");

		System.out.print("Post Order\t\t\t\t\t[");
		postOrder(root, printer);
		System.out.println("]");

		System.out.print("Level Order\t\t\t\t\t[");
		levelOrder(root, printer);
		System.out.println("]");

		System.out.print("Level Order Reverse\t\t\t[");
		levelOrderReverse(root, printer);
		System.out.println("]");

		System.out.println("======");

		ConvertAction ca = new ConvertAction();
		preOrder(root, ca);
		System.out.print("Pre order convert\t\t\t[");
		print(ca.first);
		System.out.println("]");

		System.out.print("Pre order convert Reverse\t[");
		printReverse(ca.last);
		System.out.println("]");

		System.out.println("======");

		ca = new ConvertAction();
		inOrder(root, ca);
		System.out.print("In order convert\t\t\t[");
		print(ca.first);
		System.out.println("]");

		System.out.print("In order convert Reverse\t[");
		printReverse(ca.last);
		System.out.println("]");

		System.out.println("======");

		ca = new ConvertAction();
		postOrder(root, ca);
		System.out.print("Post order convert\t\t\t[");
		print(ca.first);
		System.out.println("]");

		System.out.print("Post order convert Reverse\t[");
		printReverse(ca.last);
		System.out.println("]");

		System.out.println("======");

		// only one of these can be used because it changes all the pointers (left/right)
//		System.out.print("Convert In Order\t\t\t[");
//		convertInOrder( root );
//		print( head );
//		System.out.println("]");
//
//		System.out.print("Convert In Order 2\t\t\t[");
//		convertInOrder2( root );
//		print( head );
//		System.out.println("]");
//
//		System.out.print("Convert Pre Order\t\t\t[");
//		convertPreOrder( root );
//		print( head );
//		System.out.println("]");
	}

	public int fun(Node node) {

		if (node == null) return 0;

		if (node.left == null && node.right == null) return 0;

		return 1 + fun(node.left) + fun(node.right);
	}

	public int maxDepth(Node node) {

		if (node == null) {
			return 0;
		}

		int left = maxDepth(node.left);
		int right = maxDepth(node.right);
		int max = Math.max(left, right);

		return max + 1;
	}


	public void preOrder(Node node, Action a) {

		a.doWork(node);

		if (node.left != null) {
			preOrder(node.left, a);
		}

		if (node.right != null) {
			preOrder(node.right, a);
		}

	}

	public void inOrder(Node node, Action a) {

		if (node.left != null) {
			inOrder(node.left, a);
		}

		a.doWork(node);

		if (node.right != null) {
			inOrder(node.right, a);
		}
	}

	public void postOrder(Node node, Action a) {

		if (node.left != null) {
			postOrder(node.left, a);
		}

		if (node.right != null) {
			postOrder(node.right, a);
		}

		a.doWork(node);
	}

	public void levelOrder(Node node, Action a) {

		if (node == null) return;

		Queue<Node> queue = new LinkedList<>();

		queue.add(node);

		while (!queue.isEmpty()) {

			Node current = queue.remove();
			a.doWork(current);

			if (current.left != null) queue.add(current.left);
			if (current.right != null) queue.add(current.right);
		}
	}

	public void levelOrderReverse(Node node, Action a) {

		if (node == null) return;

		Queue<Node> queue = new LinkedList<>();

		queue.add(node);

		while (!queue.isEmpty()) {

			Node current = queue.remove();
			a.doWork(current);

			if (current.right != null) queue.add(current.right);
			if (current.left != null) queue.add(current.left);
		}
	}

	public void print(Node first) {

		while (first != null) {
			System.out.print(first.value + " ");
			first = first.right;
		}
	}

	public void printReverse(Node last) {

		while (last != null) {
			System.out.print(last.value + " ");
			last = last.left;
		}
	}

	// ==================

	public void convertInOrder( Node root ) {

		if ( root == null ) return;

		convertInOrder( root.right );

		root.right = head;

		if ( head != null ) head.left = root;

		head = root;

		convertInOrder( root.left );
	}

	public void convertPreOrder( Node root ) {

		if ( root == null ) return;

		convertPreOrder( root.right );

		if ( head != null ) head.left = root;

		head = root;

		convertPreOrder( root.left );

		root.right = head;
	}

	// ==================


	interface Action {

		void doWork(Node n);

	}

	public static class PrintNodeAction implements Action {
		@Override
		public void doWork(Node n) {

			int left = n.left == null ? -1 : n.left.value;
			int right = n.right == null ? -1 : n.right.value;
			System.out.print(n.value + "[" + left +"|"+ right +"]  ");
		}
	}

	public static class PrintAction implements Action {
		@Override
		public void doWork(Node n) {
			System.out.print(n.value + " ");
		}
	}

	public static final Action printer = new PrintAction();
	public static final Action nodePrinter = new PrintNodeAction();

	class SumAction implements Action {
		int total = 0;

		@Override
		public void doWork(Node n) {
			total += n.value;
		}
	}


	class ConvertAction implements Action {

		Node first;
		Node last;

		@Override
		public void doWork(Node n) {

			Node newNode = new Node(n.value);
			if (first == null) {
				first = last = newNode;
				return;
			}

			if (first == last) {
				// only one node in the list
				first.right = newNode;
				newNode.left = first;
				last = newNode;
				return;
			}

			// at least two nodes in the list
			newNode.left = last;
			last.right = newNode;
			last = newNode;
		}
	}
}

