package io.n4smh.unit3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import io.n4smh.unit1.Person;

/***
 * 
 * Instance method reference
 * 
 * (x) -> instanceMethod(x) === instanceObj::instanceMethod
 *
 */

public class MethodReferenceExample2 {
	public static void main(String[] args) {

		List<Person> people = Arrays.asList(new Person("Nagesh", "MH", 24), new Person("Karthik", "Devaru", 25),
				new Person("Vijeth", "A", 25), new Person("Vasant", "Sakre", 25));

		System.out.println("Printing all the person in list");
		performConditionaly(people, p -> true, p -> System.out.println(p));
		System.out.println();

		System.out.println("Printing all the person in list");
		// Instance followed by method
		// System is a static method which fetches out object instance where as println
		// is the method. Argument type passed to println is of type Person (As
		// receiving Consumer is of type Person)
		performConditionaly(people, p -> true, System.out::println);
		System.out.println();

	}

	public static void performConditionaly(List<Person> people, Predicate<Person> condition,
			Consumer<Person> consumer) {

		for (Person p : people) {
			if (condition.test(p)) {
				consumer.accept(p);
			}
		}
	}
}
