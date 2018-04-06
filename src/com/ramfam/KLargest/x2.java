package com.ramfam.KLargest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class x2 {


	public void doIt() {

		File f = new File( "input" );
		BufferedReader bf = null;
		TreeSet<Integer> ts = new TreeSet<Integer>();


		try {
			bf = new BufferedReader( new FileReader(f) );
			String text;

			while ( (text = bf.readLine()) != null ) {

				parse( text, ts );

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if ( bf != null ) bf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


		int max = 4;
		int size = ts.size();
		Integer[] result = new Integer[size];
		result = ts.toArray(result);

		for ( int i = size ; i > 0 && max > 0 ; i--, max-- ) {

			System.out.println(result[i-1] );
		}
	}


	public void parse(String text, Set<Integer> out ) {

		StringTokenizer tokens = new StringTokenizer(text, " " );

		while ( tokens.hasMoreTokens() ) {

			out.add( Integer.parseInt(tokens.nextToken()) );

		}

	}
}
