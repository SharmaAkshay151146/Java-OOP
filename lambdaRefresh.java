// A refresher on lambdas. 
import java.util.function.*;
import java.util.*;

public class lambdaRefresh {
	public static void main(String[] args) {
		
		// Supplier Example
		//Supplier<String> sup1 = () -> str.toLowerCase();
		//Supplier<String> sup2 = str::toLowerCase;
		//System.out.println(sup1.get() + " \n" + sup2.get());


		String str = "A quick brown fox jumped over a lazy dog";
		System.out.println(str.isEmpty());

		// Predicate Example - Method is test()
		BiPredicate<String, String> pre1 = (String s,String prefix) -> s.startsWith(prefix);
		//Predicate<String> pre3 = str::isEmpty; // Invalid method reference
		BiPredicate<String, String> pre2 = String::startsWith;
		System.out.println(pre1.test(str,"A"));
		System.out.println(pre2.test(str,"A"));


		// Consumer - Method is accept()
		Consumer<String> c1 = System.out::println;
		Consumer<String> c2 = x -> System.out.println(x);

		c1.accept(str);
		c2.accept(str);

		// BiConsumer is called with two parameters. They don't 
		// have to be of the same type.
		Map<String, Integer> map = new HashMap<>();
		BiConsumer<String, Integer> b1 = map::put;
		BiConsumer<String, Integer> b2 = (k,v) -> map.put(k,v);

		b1.accept("chicken", 7);
		b2.accept("chick", 2);

		System.out.println(map);

		System.out.println(average(90,95)); // Will give an optional object
		System.out.println(average());// Like Optional[smth]

		Optional<Double> opt = average(90,100);
		//if (opt.isPresent()) { System.out.println(opt.get()); } // gives an Double
		opt.ifPresent(System.out::println); // Better 
		
		


	}

	// The Long way of writing Optional
	public static Optional<Double> average(int... scores) {
		if (scores.length == 0) return Optional.empty();
		int sum = 0;
		for (int score : scores) sum += score;
		return Optional.of((double) sum/scores.length);
	}
}