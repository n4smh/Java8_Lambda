package io.n4smh.unit1;

/***
 * Traditional way before Java 8
 * 
 * Every method is part of class. Lambda allows to create functions without
 * class
 * 
 */

public class File1_Greeter {

	public static void main(String[] args) {

		File1_Greeter greeter = new File1_Greeter();

		// Create the class which implements the interface method
		File1_Greeting helloWorldGreeting = new File1_HelloWorldGreeting();
		File1_Greeting helloN4smhGreeting = new File1_HelloN4smhGreeting();

		greeter.greet();
		greeter.greet(helloWorldGreeting);
		greeter.greet(helloN4smhGreeting);

		// Lambda expression for the same

		// Here interface name is used as type and the method signature within should
		// match the lambda function signature

		// Creates the anonymous inner class which implements the interface method
		MyLambda1 myLambda1 = () -> System.out.println("Lambda Hello world interface!");
		File1_Greeting helloWorldGreeting_lambda = () -> System.out.println("Lambda Hello World!");
		File1_Greeting helloN4smhGreeting_lambda = () -> System.out.println("Lambda Hello N4SMH!");

		System.out.println();
		myLambda1.perform();
		helloWorldGreeting_lambda.perform();
		helloN4smhGreeting_lambda.perform();

		// Anonymous inner classes
		// Lambda is kind of the below implementation but not a the same
		File1_Greeting helloWorldGreeting_anonymousInnerClass = new File1_Greeting() {

			@Override
			public void perform() {
				System.out.println("Anonymous inner class Hello World!");
			}
		};

		File1_Greeting helloN4smhGreeting_anonymousInnerClass = new File1_Greeting() {

			@Override
			public void perform() {
				System.out.println("Anonymous inner class Hello N4SMH!");
			}
		};

		System.out.println();
		helloWorldGreeting_anonymousInnerClass.perform();
		helloN4smhGreeting_anonymousInnerClass.perform();

		// It's possible to pass lambda or anonymous inner class as parameter to method
		System.out.println();
		greeter.greet(helloWorldGreeting_lambda);
		greeter.greet(helloWorldGreeting_anonymousInnerClass);
	}

	public void greet() {
		System.out.println("Hello World!");
	}

	public void greet(File1_Greeting greeting) {
		greeting.perform();
	}
}

interface MyLambda1 {
	void perform();
}

interface MyLambda2 {
	void perform();

	void perform(String name);
}
