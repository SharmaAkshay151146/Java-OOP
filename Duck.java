
import java.util.*;

public class Duck implements Comparable<Duck> {
	private String name; 
	private int weight;

	public Duck(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	public String toString() {
		return name;
	}
	
	public int compareTo(Duck d) {
		return name.compareTo(d.name);
	}

	public int getWeight() {
		return this.weight;
	}

	public static void main(String[] args) {
		List<Duck> ducks = new ArrayList<>();
		ducks.add(new Duck("Quack",7));
		ducks.add(new Duck("Puddle",10));
		ducks.add(new Duck("Keruac", 8));
		ducks.add(new Duck("Haru", 11));
		System.out.println(ducks);
		System.out.println();
		Collections.sort(ducks);
		System.out.println(ducks);		

		/*
		Comparator<Duck> byWeight = new Comparator<Duck>() {
			public int compare(Duck d1, Duck d2) {
				return d1.getWeight() - d2.getWeight();
			}
		};
		*/
		// Using the Lambda version
		Comparator<Duck> byWeight = (Duck d1, Duck d2) -> d1.getWeight() - d2.getWeight();

		// You can also use Collections.sort with weights
		Collections.sort(ducks, byWeight);
		System.out.println();
		System.out.println("Sort by weight");
		System.out.println();
		System.out.println(ducks);		
	}
}