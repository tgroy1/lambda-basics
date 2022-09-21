package streambasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import dto.Person;

public class Practice {

	public static void main(String[] args) throws Exception {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		// int sum = list.stream().reduce(0, (a,b) -> a+b);
		// int sum = list.stream().reduce(0, Integer::sum);
		// int sum = list.stream().collect(Collectors.summingInt(a -> a));

		double avg = list.stream().mapToInt(a -> a * a).average().orElseThrow(Exception::new);
		System.out.println(avg);
		double avg1 = list.stream().collect(Collectors.averagingInt(a -> a));

		IntSummaryStatistics stats = list.stream().collect(Collectors.summarizingInt(a -> a));
		IntSummaryStatistics stats2 = list.stream().mapToInt(a -> a).summaryStatistics();

		Integer[] intArr = list.stream().toArray(Integer[]::new);

		List<List<String>> namesNested = Arrays.asList(Arrays.asList("Jeff", "Bezos"), Arrays.asList("Bill", "Gates"),
				Arrays.asList("Mark", "Zuckerberg"));

		List<String> namesFlatStream = namesNested.stream()
				.flatMap(Collection::stream)
				.collect(Collectors.toList());

		long uniqueList = list.stream().distinct().count();
		System.out.println(uniqueList);

		System.out.println("-------");

		Stream<String> st = Stream.iterate("", (str) -> str + "x");
		// st.forEach(System.out::println);
		st.limit(3).map(str -> str + "y");

		List<Person> people = new ArrayList<>();
		people.add(new Person("A", "B", 10));
		people.add(new Person("M", "N", 15));
		people.add(new Person("Y", "Z", 5));
		
		people.stream().forEach(p -> p.setAge(20));
		
		System.out.println(people);

		String names = people.stream().map(Person::getFirstName).collect(Collectors.joining(",", "[", "]"));
		System.out.println(names);
		// people.forEach(System.out::println);

		// collect.forEach(System.out::print);

		List<List<Integer>> number = new ArrayList<>();

		// adding the elements to number arraylist
		number.add(Arrays.asList(1, 2));
		number.add(Arrays.asList(3, 4));
		number.add(Arrays.asList(5, 6));
		number.add(Arrays.asList(7, 8));

		System.out.println("List of list-" + number);

		// using flatmap() to flatten this list
		List<Integer> flatList = number.stream()
				.flatMap(Collection::stream)
				.collect(Collectors.toList());

		// printing the list
		System.out.println("List generate by flatMap-" + flatList);

	}

}
