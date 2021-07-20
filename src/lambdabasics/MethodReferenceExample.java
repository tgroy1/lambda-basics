package lambdabasics;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceExample {

	public static void main(String[] args) {

		// Example 1 - there is no input arg and no arg being passed to the method being
		// called
//		Thread t = new Thread(() -> printMessage());
		Thread t = new Thread(MethodReferenceExample::printMessage); //
		t.start();

		List<Person> people = Arrays.asList(new Person("John", "Terry", 26), new Person("Frank", "Lampard", 8),
				new Person("Didier", "Drogba", 11), new Person("Eden", "Hazard", 10), 
				new Person("Kai", "Havertz", 29));

		// Example 2 - there is one/more input args and same args are being passed to
		// the method being called
//		performConditionally(people, p -> true, p -> System.out.println(p));
		performConditionally(people, p -> true, System.out::println);

	}

	public static void printMessage() {
		System.out.println("printing message");
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
