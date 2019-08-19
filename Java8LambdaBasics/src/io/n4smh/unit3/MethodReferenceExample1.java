package io.n4smh.unit3;

/***
 * 
 * Static method reference
 * 
 * () -> staticMethod() === ClassName::staticMethod
 *
 */

public class MethodReferenceExample1 {
	public static void main(String[] args) {

		Thread t = null;

		// Lambda
		t = new Thread(() -> printMessage());
		t.start();

		// System.out.println();

		// Lambda method reference
		// Static methods are referenced by class name followed by method name
		t = new Thread(MethodReferenceExample1::printMessage);
		t.start();

	}

	public static void printMessage() {
		System.out.println("Hello");
	}
}
