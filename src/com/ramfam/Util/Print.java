package com.ramfam.Util;

public class Print {

	static public int max = 20;
	static private int tabs = 0;

	static private void doTab() {
		if ( tabs > max ) System.exit(-1);

		for ( int i = 0 ; i < tabs ; i++ ) {
			System.out.print("\t");
		}
	}

	static private void print(String s) {
		doTab();
		System.out.println(s);
	}

	static public void start(String s) {
		doTab();
		System.out.print(s);
	}

	static public void enter(String s) {
		print("Enter: " + s);
		tabs++;
	}

	static public void exit(String s) {
		tabs--;
		print("Exit:  "+ s);
	}

	static public void note(String s) {
		print(s);
	}


	static public void bump(String s) {
		tabs++;
		print(s);
		tabs--;
	}

}
