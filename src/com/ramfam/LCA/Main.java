package com.ramfam.LCA;


import com.ramfam.Reverse.MyList;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main( String[] args ) {

		Test t = new Test();

		t.root = new Node(1);
		t.root.left = new Node(2);
		t.root.right = new Node(3);
		t.root.left.left = new Node(4);
		t.root.left.right = new Node(5);
		t.root.right.left = new Node(6);
		t.root.right.right = new Node(7);

		System.out.println("LCA(4, 5): " + t.find(4,5));
		System.out.println("LCA(4, 6): " + t.find(4,6));
		System.out.println("LCA(3, 4): " + t.find(3,4));
		System.out.println("LCA(2, 4): " + t.find(2,4));

	}

}