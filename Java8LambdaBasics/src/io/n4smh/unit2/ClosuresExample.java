package io.n4smh.unit2;

/***
 * 
 * Closures
 *
 */

public class ClosuresExample {
	public static void main(String[] args) {

		int a = 10;
		int b = 5; // Effectively final. If final keyword is mentioned its actual final.

		// Java 7 way -> Similar to closure
		doProcess(a, new Process() {

			@Override
			public void process(int i) {

				// Compiler keeps track of value b.
				// b = 40; // Error: b must be final or effectively final
				System.out.println(i + b);

			}
		});

		// Java 8 way -> Closure
		// Freezes the value of b at the time of the lambda creation and b should be
		// actually final.
		doProcess(a, i -> System.out.println(i + b));

		// b = 40; // Error: b must be final or effectively final
	}

	public static void doProcess(int i, Process p) {
		p.process(i);
	}

}

interface Process {
	void process(int i);
}