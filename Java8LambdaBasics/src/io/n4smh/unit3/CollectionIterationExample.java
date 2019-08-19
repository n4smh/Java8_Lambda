package io.n4smh.unit3;

import java.util.Arrays;
import java.util.List;

import io.n4smh.unit1.Person;

/***
 * 
 * Lambda internal iterator
 * 
 * How the iteration happens is upto the runtime, execution order is not
 * maintained/specified. May use multi threading. Better performance.
 * 
 */

public class CollectionIterationExample {
	public static void main(String[] args) {

		List<Person> people = Arrays.asList(new Person("Nagesh", "MH", 24), new Person("Karthik", "Devaru", 25),
				new Person("Vijeth", "A", 25), new Person("Vasant", "Sakre", 25));

		// External iterator
		// Specifying how to iterate
		System.out.println("Using for loop");
		for (int i = 0; i < people.size(); i++) {
			System.out.println(people.get(i));
		}
		System.out.println();

		// External iterator
		// Instructing compiler/runtime to perform the iteration in specific manner
		System.out.println("Using for-in loop");
		for (Person person : people) {
			System.out.println(person);
		}
		System.out.println();

		// Internal iterator
		// How the iteration happens is upto the runtime
		System.out.println("Using lambda");
		people.forEach(person -> System.out.println(person));
		System.out.println();

		// Method reference
		System.out.println("Using lambda method reference");
		people.forEach(System.out::println);
		System.out.println();
	}
}
