package overriding_Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OverridingSortingComparableInterface implements Comparable<OverridingSortingComparableInterface>{
	
	private int id;
	private String name;
	
	OverridingSortingComparableInterface(int id) {
		this.id = id;
	}
	
	OverridingSortingComparableInterface(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public static void main(String[] args) {
		
		// Collection of Integers
		List<OverridingSortingComparableInterface> list = new ArrayList<>();
		list.add(new OverridingSortingComparableInterface(1));
		list.add(new OverridingSortingComparableInterface(23));
		list.add(new OverridingSortingComparableInterface(99));
		list.add(new OverridingSortingComparableInterface(55));
		list.add(new OverridingSortingComparableInterface(11));
		
		//Collections.sort(list);
		
		//list.stream().forEach(i -> System.out.println(i.getId()));
		
		// Collection of Strings
		List<OverridingSortingComparableInterface> list2 = new ArrayList<>();
		list2.add(new OverridingSortingComparableInterface("df"));
		list2.add(new OverridingSortingComparableInterface("a"));
		list2.add(new OverridingSortingComparableInterface("zdf"));
		list2.add(new OverridingSortingComparableInterface("ioui"));
		list2.add(new OverridingSortingComparableInterface("b"));
		
		Collections.sort(list2);
		
		list2.stream().forEach(i -> System.out.println(i.getName()));
	}
	/*
	 * For Primitives 
	 */
	
	/*
	@Override
	public int compareTo(OverridingSortingComparableInterface o) {
		
		// Ascending Order
		return this.id - o.id;
		
		// Descending Order
		// return o.id - this.id;
	}
	
	*/
	
	/*
	 * For Objects 
	 */
	
	
	@Override
	public int compareTo(OverridingSortingComparableInterface o) {
		
		// Ascending Order
		return this.name.compareTo(o.name);
		
		// Descending Order
		// return o.name.compareTo(this.name);
	}
	
}