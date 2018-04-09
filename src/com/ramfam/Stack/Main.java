package com.ramfam.Stack;


import java.util.Arrays;
import java.util.Stack;

public class Main {


	public static void main( String[] args ) {

		{
			MyStack ms = new MyStack();

			ms.push( 15 );
			ms.push( 9 );
			ms.push( 33 );
			ms.push( 36 );
			ms.push( 99 );
			ms.push( 4 );
			ms.push( 36 );
			ms.push( 106 );
			ms.push( 8 );

			System.out.println("min="+ms.getMin());

			ms.pop();
			ms.pop();
			ms.pop();
			ms.pop();
			System.out.println("min="+ms.getMin());
		}
		System.out.println("--------");
		{
			MyStack2 ms = new MyStack2();

			ms.push( 15 );
			ms.push( 9 );
			ms.push( 33 );
			ms.push( 36 );
			ms.push( 99 );
			ms.push( 4 );
			ms.push( 36 );
			ms.push( 106 );
			ms.push( 8 );

			System.out.println("min="+ms.getMin());

			ms.pop();
			ms.pop();
			ms.pop();
			ms.pop();
			System.out.println("min="+ms.getMin());
		}
	}
}