package com.ramfam.Stack;

import java.util.Stack;

public class MyStack  extends Stack<Integer> {

	Stack<Integer> min = new Stack<>();

	@Override
	public Integer push(Integer item) {

		super.push( item );

		if ( min.isEmpty() ) {
			min.push( item );
		} else if ( item.longValue() < min.peek().longValue() ) {
			min.push( item );
		} else {
			min.push( min.peek() );
		}

		return item;
	}

	public Integer pop() {
		Integer x = super.pop();
		min.pop();
		return x;
	}

	Integer getMin() {
		return min.peek();
	}
}

