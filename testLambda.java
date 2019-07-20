import java.util.*;
import java.time.*;
import java.util.function.*;
/* We need to be concerned with 4 types of functional interfaces:
* Suppliers -> Its functional method get() never takes anything but returns smth
* Consumer -> Its functional method accept() always takes smth but returns nada
* Predicate -> Its functional method test() takes a value and returns a boolean
* Function -> Its functional method apply() takes an arg and returns a value 

* How is an interface functional ?
* An interface is functional if it has exactly one abstract method. Default, 
* static, and methods inherited from Object class don't count. 
*/


public class testLambda {
	public static void main(String[] args) {
		////************** Method References *******************
		String str = "abc";
		Predicate<String> methodRef1 = String::isEmpty;
		Predicate<String> lambda1 = s -> s.isEmpty();
		System.out.println(methodRef1 + " " + lambda1);
		
		
		//************** Supplier *******************
		
		Supplier<LocalDate> s1 = LocalDate::now; // Method Ref 
		Supplier<LocalDate> s2 = () -> LocalDate.now(); // lambda
		
		LocalDate d1 = s1.get();
		LocalDate d2 = s2.get();
		
		System.out.println(d1 + "  " + d2);
		
		Supplier<StringBuilder> s3 = StringBuilder::new;
		Supplier<StringBuilder> s4 = () -> new StringBuilder();
		System.out.println(s3.get() + " " + s4.get());
		
		// Without using Lambdas
		Supplier<LocalDate> date = new Supplier<LocalDate>() {
			public LocalDate get() {
				return LocalDate.now();
			}
		};
		System.out.println(date.get());
		
		//************** Consumer *******************
		// You use it when you want to do something with a parameter but not 
		// return anything. 
		// @FunctionalInterface public class Consumer<T> {
		//		void accept(T t); }
		
		Consumer<String> c1 = System.out::println;
		Consumer<String> c2 = x -> System.out.println(x);
		
		c1.accept("Annie"); c2.accept("Helen");
		
		//************** BiConsumer *******************
		// Like consumer but with 2 arguments
		Map<String, Integer> map = new HashMap<>();
		BiConsumer<String, Integer> b1 = map::put; // Method Reference 
		BiConsumer<String, Integer> b2 = (k,v) -> map.put(k,v);
		
		b1.accept("Chamber of Secrets",2); b2.accept("Philsopher's Stone", 1);
		System.out.println(b1 + " " + b2);
		System.out.println(map);
		
		
		// You can use same type for T and U in BiConsumer
		Map<String, String> mappy = new HashMap<>();
		BiConsumer<String, String> b3 = mappy::put; // Method Reference 
		BiConsumer<String, String> b4 = (k,v) -> mappy.put(k,v);
		
		b3.accept("Harry", "Potter"); b4.accept("Ron","Weasley");
		System.out.println(mappy);
		
		// ************** Predicate *******************
		Predicate<String> test1 = String::isEmpty;
		Predicate<String> test2 = x -> x.isEmpty();
		
		System.out.println(test1.test("Harry"));
		System.out.println(test2.test("Ron"));
		
		BiPredicate<String, String> b5 = String::startsWith;
		BiPredicate<String, String> b6 = (string, prefix) -> string.startsWith(prefix);
		
		System.out.println(b5.test("chicken","chick"));
		System.out.println(b6.test("polla","poll"));
		
		// ************** Function *******************
		// Turns one parameter into a value of a diff type and returns it 
		// @FunctionalInterface public class Function<T,R> {
		// R apply(T t) ; }
		
		// This function converts a string to the length of string 
		Function<String,Integer> f1 = String::length; // Method Ref :(
		Function<String, Integer> f2 = x -> x.length();
		
		System.out.println(f1.apply("Harry Potter"));
		System.out.println(f2.apply("For Whom The Bell Tolls"));
		
		BiFunction<String, String, String> f3 = String::concat;
		BiFunction<String, String, String> f4 = (string, toAdd) -> string.concat(toAdd);
		
		System.out.println(f3.apply("Harry","Potter"));
		System.out.println(f4.apply("For Whom The", " Bell Tolls"));
	
		// ************** UnaryOperator *******************
		// A special case of function. They require all type parameters to be of 
		// the same type. 
		// A UnaryOperator transforms its value into one of the same type. 
		// Eg. Incrementing by one 
		// A BinaryOperator merges two values into one of the same type. 
		// Eg. Adding two numbers is a binary operation. 
		// @FunctionalInterface public class UnaryOperator<T> extends Function<T, T> { }
		
		UnaryOperator<String> u1 = String::toUpperCase;
		UnaryOperator<String> u2 = x -> x.toLowerCase();
		// No need to specify the return type because UnaryOperator requires 
		// it to be the same as the parameter
		
		//UnaryOperator<> ui3 = System.out::println;
		//System.out.println(ui3.apply("Unary Operator"));
		
		// ************** BinaryOperator *******************
		
		BinaryOperator<String> bi1 = String::concat;
		BinaryOperator<String> bi2 = (string, toAdd) -> string.concat(toAdd);
		
		System.out.println(bi1.apply("Harry", "Potter"));
		System.out.println(bi2.apply("Ron", "Weasley"));
		
		
		System.out.println(u1.apply("harry"));
		System.out.println(u2.apply("HARRY"));
	
	}
}