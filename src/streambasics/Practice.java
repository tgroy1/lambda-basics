package streambasics;

import java.util.Arrays;
import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Practice {

	public static void main(String[] args) throws Exception {
		
		List<Integer> list = Arrays.asList(1,2,3,4,5,1,2);
		
		//int sum = list.stream().reduce(0, (a,b) -> a+b);
		//int sum = list.stream().reduce(0, Integer::sum);
		//int sum = list.stream().collect(Collectors.summingInt(a -> a));
		
		double avg = list.stream().mapToInt(a->a).average().orElseThrow(Exception::new);
		
		IntSummaryStatistics stats = list.stream().collect(Collectors.summarizingInt(a -> a));
		IntSummaryStatistics stats2 = list.stream().mapToInt(a -> a).summaryStatistics();
		
		Integer[] intArr = list.stream().toArray(Integer[]::new);
		
		List<List<String>> namesNested = Arrays.asList( 
			      Arrays.asList("Jeff", "Bezos"), 
			      Arrays.asList("Bill", "Gates"), 
			      Arrays.asList("Mark", "Zuckerberg"));
		
		
		List<String> namesFlatStream = namesNested.stream()
				.flatMap(Collection::stream)
				.collect(Collectors.toList());
		
		List<Integer> uniqueList = list.stream().distinct().collect(Collectors.toList());
		
		
		
		
	    //collect.forEach(System.out::print);
		
	}

}
