package lambdabasics;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import dto.Person;

public class PersonLambdaRunner {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(new Person("John", "Terry", 26), new Person("Frank", "Lampard", 8),
				new Person("Didier", "Drogba", 11), new Person("Eden", "Hazard", 10), 
				new Person("Kai", "Havertz", 29));

		// Sort list by last name
//		Comparator compByLastName = new Comparator<Person>() {
//
//			@Override
//			public int compare(Person o1, Person o2) {
//				return o1.getLastName().compareTo(o2.getLastName());
//			}
//		};

		people.sort((o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));

//		System.out.println(people);

		// Create a method that prints all elements in the list
//		people.forEach(p -> System.out.println(p));
//		printConditionally(people, p -> true);
		performConditionally(people, p -> true, p -> System.out.println(p));

		// Create a method that prints all people whose last name begins with H
		System.out.println("-------------");
//		people.stream().filter(p -> p.getLastName().startsWith("H")).forEach(System.out::println);
//		people.forEach(p -> {
//			if (p.getLastName().startsWith("H")) {
//				System.out.println(p);
//			}
//		});
//		printConditionally(people, p -> p.getLastName().startsWith("H"));
		performConditionally(people, p -> p.getLastName().startsWith("H"), p -> System.out.println(p));
	}

	private static void printConditionallyCustom(List<Person> people, Condition condition) {
		for (Person p : people) {
			if (condition.test(p)) {
				System.out.println(p);
			}
		}
	}

	private static void printConditionally(List<Person> people, Predicate<Person> predicate) {
		for (Person p : people) {
			if (predicate.test(p)) {
				System.out.println(p);
			}
		}
	}

	private static void performConditionally(List<Person> people, Predicate<Person> predicate,
			Consumer<Person> consumer) {
		for (Person p : people) {
			if (predicate.test(p)) {
				consumer.accept(p);
			}
		}
	}

}

interface Condition {
	boolean test(Person p);
}
