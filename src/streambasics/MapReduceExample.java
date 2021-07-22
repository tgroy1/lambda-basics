package streambasics;

import java.util.Arrays;
import java.util.List;

//Double each value and get their sum
public class MapReduceExample {

	public static void main(String[] args) {
		
		List<Integer> values = Arrays.asList(1,2,3,4,5,6);
		
		System.out.println(values.stream()
								 .map(i -> i*2)
								 .reduce(0, Integer::sum));

	}

}
