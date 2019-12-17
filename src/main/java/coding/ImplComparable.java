package coding;

import java.util.ArrayList;
import java.util.Collections;

public class ImplComparable implements Comparable<ImplComparable> {

	private String name;
	public int id;

	public ImplComparable(String name) {
		this.name = name;
	}
	
	public ImplComparable(int id) {
		this.id = id;
	}

	public static void main(String[] args) {
		ArrayList<ImplComparable> list1 = new ArrayList<ImplComparable>();
		list1.add(new ImplComparable("AAA"));
		list1.add(new ImplComparable("bbksjf"));
		list1.add(new ImplComparable("zz"));
		list1.add(new ImplComparable("udfsyir"));
		list1.add(new ImplComparable("aa"));

		Collections.sort(list1);
		for (ImplComparable l : list1) {
			System.out.println(l.name);
		}
		System.out.println("------------------");
		
		ArrayList<ImplComparable> list2 = new ArrayList<ImplComparable>();
		list2.add(new ImplComparable(457));
		list2.add(new ImplComparable(1));
		list2.add(new ImplComparable(7789));
		list2.add(new ImplComparable(12));
		list2.add(new ImplComparable(66));
		
		Collections.sort(list2);
		for(ImplComparable l : list2)
			System.out.println(l.id);
	}

	/*
	 * @Override public int compareTo(ImplComparable o) {
	 * 
	 * This prints the order in reverse return o.name.compareTo(this.name);
	 * 
	 * return this.name.compareTo(o.name); }
	 */
	@Override
	public int compareTo(ImplComparable o) {
		return this.id - o.id;
	}

}
