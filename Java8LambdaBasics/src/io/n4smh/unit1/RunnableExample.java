package io.n4smh.unit1;

/***
 * This is a classic example why interface are used to define lambda type
 * instead of new function.
 * 
 * Backward compatibility
 * 
 * We already have number of library with interface in place, we can directly
 * pass lambda function to those and it still works fine.
 * 
 * If new type was introduced then all the library should be rewritten to accept
 * that new type and work as intended.
 * 
 */

public class RunnableExample {

	public static void main(String[] args) {

		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Inside runnable");

			}

		});

		thread1.run();

		// Lambda for the same
		Thread thread2 = new Thread(() -> System.out.println("Inside runnable lambda"));
		thread2.run();
	}
}
