import java.util.*;

class Cat implements Comparable<Cat> {
	private String name;
	private int weight;
	private int age;

	public Cat (String name, int weight, int age) {
		this.name = name;
		this.weight = weight;
		this.age = age;
	}
	public String toString() { return name; }
	public String getName () { return this.name; }
	public int getWeight() { return this.weight; }
	public int getAge() { return this.age; }

	public int compareTo(Cat c) { return name.compareTo(c.name); }

}

public class catSelector {
	public static void main(String[] args) {
		List<Cat> cats = new ArrayList<Cat>();
		cats.add(new Cat("Neko", 30, 10));
		cats.add(new Cat("Gato", 25, 8));
		cats.add(new Cat("Billi", 33, 11));
		cats.add(new Cat("Kass", 35, 12));
		cats.add(new Cat("Chat", 23, 7));

		System.out.println(cats);
		System.out.println();
		Collections.sort(cats);
		System.out.println();
		System.out.println(cats);

		Comparator<Cat> byWeight = (c1, c2) -> c1.getWeight() - c2.getWeight();
		Comparator<Cat> byAge = (c1, c2) -> c1.getAge() - c2.getAge();

		System.out.println();
		System.out.println("Sort by Weight");
		Collections.sort(cats, byWeight);
		System.out.println(cats);

		System.out.println();
		System.out.println("Sort by Age");
		Collections.sort(cats, byAge);
		System.out.println(cats);

	}
}