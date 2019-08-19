package io.n4smh.unit2;

/***
 * 
 * 'this' reference
 * 
 * Lambda does'nt modify the 'this' reference. It remains same as it was outside
 * the lambda expression.
 * 
 * Anonymous inner classes overwrites the 'this' reference.
 * 
 * Proof that lambda is not implemented as anonymous inner class.
 *
 */

public class ThisReferenceExample {
	public static void main(String[] args) {

		ThisReferenceExample obj = new ThisReferenceExample();

		// Anonymous inner class
		obj.doProcess(10, new Process() {

			@Override
			public void process(int i) {
				System.out.println("i: " + i);

				// 'this' reference to anonymous inner class Process created in-line
				// io.n4smh.unit2.ThisReferenceExample$1@15db9742, a unique token identified as
				// part of ThisReferenceExample ($*@*)
				// 'this' is overwritten by anonymous inner class
				System.out.println(this);
				System.out.println();

			}

			@Override
			public String toString() {
				System.out.println("Inside anonymous inner class toString()");
				return super.toString();
			}
		});

		// Error: Cannot use this in a static context
		// System.out.println(this);

		// Java 8 lambda
		obj.doProcess(10, i -> {
			System.out.println(i);

			// In the below case its still a static reference to ThisReferenceExample.

			// Error: Cannot use this in a static context
			// System.out.println(this);
			System.out.println();
		});

		obj.execute();

	}

	public void execute() {
		System.out.println("Inside execute");
		System.out.println(this);

		doProcess(10, i -> {
			System.out.println("i: " + i);

			// In the below case its still pointing to the instance of ThisReferenceExample
			System.out.println(this);
			System.out.println();
		});
	}

	public void doProcess(int i, Process p) {
		p.process(i);
	}

	@Override
	public String toString() {
		System.out.println("Inside ThisReferenceExample toString()");
		return super.toString();
	}
}
