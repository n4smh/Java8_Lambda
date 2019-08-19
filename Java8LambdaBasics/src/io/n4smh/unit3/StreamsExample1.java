package io.n4smh.unit3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import io.n4smh.unit1.Person;

/***
 * 
 * Java 8 Streams
 * 
 * A sequence of elements supporting sequential and parallel aggregate
 * operations.
 * 
 * Streams allow parallel processing. Sequence is implicit to runtime.
 *
 */

public class StreamsExample1 {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(new Person("Nagesh", "MH", 24), new Person("Karthik", "Devaru", 25),
				new Person("Vijeth", "A", 25), new Person("Vasant", "Sakre", 25));

		// Step3: Create a method all the people whose name starts with V
		people.stream().filter(person -> person.getFirstname().startsWith("V"))
				.forEach(person -> System.out.println(person.getFirstname()));

		System.out.println();

		// View of people, no iteration is performed yet.
		Stream<Person> peopleStream1 = people.stream();

		// View of people with filter applied, no iteration is performed yet.
		Stream<Person> peopleStream2 = people.stream().filter(person -> person.getFirstname().startsWith("V"));

		// Only on end conditions iteration is performed
		System.out.println("Total number of persons: " + peopleStream1.count());
		System.out.println("Number of persons whose name starts with V: " + peopleStream2.count());

		// For each stream we can have only one end condition/operation
		// Error: stream has already been operated upon or closed
		// System.out.println("Number of persons whose name starts with V: " +
		// peopleStream2.count());

		System.out.println();

		// Parallel stream
		people.parallelStream().filter(person -> person.getFirstname().startsWith("V"))
				.forEach(person -> System.out.println(person.getFirstname()));

	}
}
