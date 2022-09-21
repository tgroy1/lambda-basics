package streambasics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import dto.Person;

public class StreamRunner {

	public static void main(String[] args) {
		
		List<Person> people = new ArrayList<>();
		
		for (int i=0; i<10; i++) {
			Person p = new Person("First name " + i, "Last Name " + i, i%100);
			people.add(p);
		}
		
		long start = System.currentTimeMillis();
		people.forEach(System.out::println); //will maintain order
		people.stream().forEach(System.out::println); //may not maintain order
		people.parallelStream().forEach(System.out::println); //may not maintain order
		long end = System.currentTimeMillis();
		System.out.println("Printing took " + (end - start) + " ms");
		
		//The same stream cannot be used more than once
		Stream<Person> stream = people.stream();
		stream.forEach(System.out::println);
		//stream.forEach(System.out::println); //Exception -> java.lang.IllegalStateException: stream has already been operated upon or closed
		
		
		

	}

}
