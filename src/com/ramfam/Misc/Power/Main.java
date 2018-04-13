package com.ramfam.Misc.Power;

public class Main {

	public static void main( String[] args ) {

		int num = 5;
		int power = 6;

		int result = num;


		for ( int i = 1 ; i < power ; i++ ) {
			result *= num;
		}

		System.out.println(result);
	}
}
