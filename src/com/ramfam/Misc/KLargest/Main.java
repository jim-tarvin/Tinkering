package com.ramfam.Misc.KLargest;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

    	int top = 6;

    	List<Integer> result = fillArray("input" );
    	Integer []work = new Integer[result.size()];
    	result.toArray( work );

		Arrays.sort( work, Collections.reverseOrder() );

    	int size = result.size();


    	for ( int i = size ; i > 0 && top > 0 ; i--, top-- ) {
			System.out.println(work[i-1]);
		}

		System.out.println(result);

    }


	static List<Integer> fillArray(String fileName ) {

		File f = new File( fileName );
		BufferedReader reader = null;
		String line;
		ArrayList<Integer> out = new ArrayList<>();

		try {
			reader = new BufferedReader( new FileReader(f) );

			while ( (line = reader.readLine()) != null ) {

				fillArray( line, out );

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e ) {
			e.printStackTrace();
		} finally {
			try {
				if ( reader != null ) reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return out;
	}


	static void fillArray( String line, List<Integer> out ) {

		StringTokenizer tokes = new StringTokenizer(line," ");

		while ( tokes.hasMoreTokens() ) {

			out.add( Integer.parseInt(tokes.nextToken()) );

		}
	}

}
