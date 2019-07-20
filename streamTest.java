import java.util.stream.*;
import java.util.*;

public class streamTest {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("w","o","l","f");
        String word = stream.reduce("",(s,c) -> s + c);
        System.out.println(word);

        Stream<String> stream2 = Stream.of("w","o","l","f");
        String word2 = stream2.reduce("",String::concat);
        System.out.println(word2);

        //Stream<String> s = Stream.of("brown-", "bear-");
        //s.sorted().forEach(System.out::print);

        Stream<String> s1 = Stream.of("monkey", "gorilla", "bonobo");
        //Stream<String> infinite = Stream.generate(() -> "chimp");
        //s1.findAny().ifPresent(System.out::println); 
        //infinite.findAny().ifPresent(System.out::println);
        Optional<String> min = s1.min((s2,s3) -> s2.length() - s3.length());
        min.ifPresent(System.out::println);

        Stream<String> stream_b = Stream.of("w", "o", "l", "f");
        TreeSet<String> set = stream_b.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        System.out.println(set);
        
    }
}