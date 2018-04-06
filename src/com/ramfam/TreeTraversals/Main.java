package com.ramfam.TreeTraversals;


public class Main {

    public static void main(String[] args) {

        Node root = build();
        DoIt doit = new DoIt();

        doit.go(root);



    }


    static Node build() {

        Node root = new Node();

        root.left = new Node();
        root.right = new Node();

        root.left.left = new Node();
        root.left.right = new Node();
        root.left.left.left = new Node();

        root.left.right.left = new Node();
        root.left.right.right = new Node();

        root.right.left = new Node();
        root.right.right = new Node();
        root.right.left.left = new Node();

        root.right.right.left = new Node();
        root.right.right.right = new Node();
        root.right.right.right.left = new Node();
        root.right.right.right.right = new Node();
        root.right.right.right.right.right = new Node();

        return root;
    }
}
