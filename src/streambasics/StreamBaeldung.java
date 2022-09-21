package streambasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import dto.Product;

public class StreamBaeldung {

	public static void main(String[] args) {
		
		Logger log = Logger.getLogger("");
		
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		//Stream creation
		Stream<String> stream = streamOf(list);
		
		Stream<String> streamOf = Stream.of("a","b","c");
		
		String[] arr = new String[]{"a", "b", "c"};
		Stream<String> streamOfArrayFull = Arrays.stream(arr);
		Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
		
		Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();
		
		Stream<String> streamGenerated = Stream.generate(() -> "element").limit(10);
		Stream<Double> randomInts = Stream.generate(Math::random).limit(5);
		Stream.generate(() -> new Random().nextInt(100)).limit(5).forEach(System.out::println);
		
		Stream<Integer> streamIterated = Stream.iterate(10, n->n+1).limit(10);
		
		IntStream intStream = IntStream.range(1, 3);
		LongStream longStream = LongStream.rangeClosed(1, 3);
		
		Random random = new Random();
		DoubleStream doubleStream = random.doubles(3);
		
		IntStream streamOfChars = "abc".chars();
		streamOfChars.forEach(System.out::println);
		
		Stream<String> streamOfString = Pattern.compile(", ").splitAsStream("a, b, c");
		
		//Stream Pipeline
		Stream<String> twiceModifiedStream = Stream.of("abcd", "cbcd", "bbcd").skip(1)
													.map(element -> element.substring(0, 3))
													.sorted();

		
		//Lazy Invocation
		Optional<String> lazyStream = Arrays.asList("abc1", "abc2", "abc3").stream().filter(element -> {
		    //log.info("filter() was called");
			System.out.println("filter() was called");
		    return element.contains("2");
		}).map(element -> {
		    log.info("map() was called");
		    return element.toUpperCase();
		}).findFirst();
		
		System.out.println(lazyStream);
		
		//Stream Reduction
		int reducedTwoParams = IntStream.range(1, 4).reduce(10, (a, b) -> a + b);
		System.out.println(reducedTwoParams);
		
		int reducedParallel =  Arrays.asList(1, 2, 3).parallelStream()
				.reduce(10, (a, b) -> a + b, (a, b) -> a + b);
		System.out.println(reducedParallel); //(10 + 1 = 11; 10 + 2 = 12; 10 + 3 = 13;) -> (12 + 13 = 25; 25 + 11 = 36)
		
		List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
				  new Product(14, "orange"), new Product(13, "lemon"),
				  new Product(23, "bread"), new Product(13, "sugar"));
		List<String> collectorCollection = productList.stream().map(Product::getName).collect(Collectors.toList());
		
		String listToString = productList.stream().map(Product::getName)
				  .collect(Collectors.joining(",", "[", "]"));
		System.out.println(listToString);
		
		double averagePrice1 = productList.stream()
				  .collect(Collectors.averagingInt(Product::getPrice));
		double averagePrice2 = productList.stream()
				  .mapToInt(Product::getPrice).average().orElse(0.0);
		System.out.println(averagePrice1);
		
		IntSummaryStatistics summingPrice = productList.stream()
				  .collect(Collectors.summarizingInt(Product::getPrice));
		System.out.println(summingPrice);
		
		Map<Integer, List<Product>> collectorMapOfLists = productList.stream()
				  .collect(Collectors.groupingBy(Product::getPrice));
		System.out.println(collectorMapOfLists);
		
		Map<Boolean, List<Product>> mapPartioned = productList.stream()
				  .collect(Collectors.partitioningBy(element -> element.getPrice() > 15));
		System.out.println(mapPartioned);
		
		Set<Product> unmodifiableSet = productList.stream()
				  .collect(Collectors.collectingAndThen(Collectors.toSet(),
				  Collections::unmodifiableSet));
		
//		streamOfArrayPart.forEach(System.out::println);
	}

	public static Stream<String> streamOf(List<String> list) {
	    return list == null || list.isEmpty() ? Stream.empty() : list.stream();
	}
	
}
