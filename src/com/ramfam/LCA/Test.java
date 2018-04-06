package com.ramfam.LCA;

import java.util.ArrayList;
import java.util.List;

public class Test {

	Node root;
	private List<Integer> v1Path = new ArrayList<>();
	private List<Integer>	v2Path = new ArrayList<>();

	int find( int value1, int value2 ) {

		v1Path.clear();
		v2Path.clear();

		return findEm( root, value1, value2 );

	}

	int findEm( Node root, int value1, int value2 ) {

		boolean found1 = find( root, value1, v1Path );
		boolean found2 = find( root, value2, v2Path );

		if ( ! found1 || !found2 ) return -1;

		int i;
		for ( i = 0 ; i < v1Path.size() && i < v2Path.size() ; i++ ) {
			if ( ! v1Path.get(i).equals(v2Path.get(i)))
				break;
		}

		return v1Path.get(i-1);
	}

	boolean find( Node node, int seek, List<Integer> path ) {

		if ( node == null ) return false;

		path.add( node.value );

		if ( node.value == seek ) return true;

		if ( node.left != null && find(node.left,seek,path) ) {
			return true;
		}

		if ( node.right != null && find(node.right,seek,path) ) {
			return true;
		}

		path.remove( path.size() - 1 );	// seek value wasn't found under this node

		return false;
	}
}
