package streambasics;

import java.util.Arrays;
import java.util.List;

//Get sum of all values divisible by 5
public class FilterReduceExample {

	public static void main(String[] args) {
		
		List<Integer> values = Arrays.asList(12,23,30,37,45);
		
		System.out.println(values.stream()
								 .filter(i -> i%5 == 0)
								 .reduce(0, Integer::sum));

	}

}
