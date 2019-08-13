package io.n4smh.unit2;

import java.util.function.BiConsumer;

public class ExceptionHandelingExample {
	public static void main(String[] args) {
		int[] someNumbers = { 1, 2, 3, 4, 5 };
		int key = 2;

		// Divide each element by key
		System.out.println("Dividing each number by " + key);
		process(someNumbers, key, (intVal1, intVal2) -> System.out.println(intVal1 / intVal2));
		System.out.println();

		key = 0;
		System.out.println("Dividing each number by " + key); // Above method throws exception
		process(someNumbers, key, wrapperLambda((intVal1, intVal2) -> System.out.println(intVal1 / intVal2)));
		System.out.println();

	}

	private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> biConsumer) {
		for (int i : someNumbers) {
			biConsumer.accept(i, key);
		}
	}

	// Wrapper lambda accepts the lambda and executes the same within the new lambda
	// having same signature as the one passed to it and returns the same.
	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> biConsumer) {
		return (intVal1, intVal2) -> {
			try {

				biConsumer.accept(intVal1, intVal2);

			} catch (ArithmeticException e) {
				System.out.println("Arithmetic exception occurred");
			}
		};
	}
}
