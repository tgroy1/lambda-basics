package lambdabasics;

import java.util.function.BiConsumer;

public class ExceptionHandling {

	public static void main(String[] args) {
		
		int[] someNumbers = {1,2,3,4,5};
		int key = 0;
		
		process(someNumbers, key, wrapperLambda((v,k) -> System.out.println(v / k)));

	}

	private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
		for (int i: someNumbers) {
			consumer.accept(i, key);
		}
	}
	
	//Generic wrapper lambda for a BiConsumer which handles exceptions to keep the original lambda clean
	private static <T, U> BiConsumer<T, U> wrapperLambda(BiConsumer<T, U> consumer) {
		return (v,k) -> {
			try {
				consumer.accept(v, k);
			} catch (Exception e) {
				System.out.println("Exception occurred due to " + e.getMessage());
			}
			
		};
		
	}

}
