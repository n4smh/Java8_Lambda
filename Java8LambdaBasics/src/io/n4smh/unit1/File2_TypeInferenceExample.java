package io.n4smh.unit1;

/***
 * Type inference is handled by compiler
 * 
 * It fetches the number of arguments, it's type and the method return type from
 * interface.
 * 
 */

public class File2_TypeInferenceExample {

	public static void main(String[] args) {

		StringLengthLambda lambda1 = (String s) -> s.length();

		// No need to mention type of argument, compiler gets that info from interface
		StringLengthLambda lambda2 = (s) -> s.length();

		// No need of parentheses if there is only one argument
		StringLengthLambda lambda3 = s -> s.length();

		System.out.println("Hello World! - length: " + lambda1.getLength("Hello World!"));
		System.out.println("Hello World! - length: " + lambda2.getLength("Hello World!"));
		System.out.println("Hello World! - length: " + lambda3.getLength("Hello World!"));

		// Lambda function could be passed instead of lambda variable in method call
		System.out.println();
		printLambda(s -> s.length());
	}

	public static void printLambda(StringLengthLambda lambda) {
		System.out.println("Hello World! - length: " + lambda.getLength("Hello World!"));
	}

	interface StringLengthLambda {
		int getLength(String s);
	}
}
