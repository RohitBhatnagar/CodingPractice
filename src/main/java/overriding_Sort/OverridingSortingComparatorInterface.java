package overriding_Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OverridingSortingComparatorInterface implements Comparator<OverridingSortingComparatorInterface> {
	
	private int id;
	private String name;
	
	OverridingSortingComparatorInterface() {
		
	}
	
	OverridingSortingComparatorInterface(int id) {
		this.id = id;
	}
	
	OverridingSortingComparatorInterface(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public static void main(String[] args) {
		
		OverridingSortingComparatorInterface c = new OverridingSortingComparatorInterface();
		
		// Collection of Integers
		List<OverridingSortingComparatorInterface> list = new ArrayList<>();
		list.add(new OverridingSortingComparatorInterface(2));
		list.add(new OverridingSortingComparatorInterface(23));
		list.add(new OverridingSortingComparatorInterface(77));
		list.add(new OverridingSortingComparatorInterface(11));
		list.add(new OverridingSortingComparatorInterface(1));
		
		//Collections.sort(list, c);
		
		//list.stream().forEach(i -> System.out.println(i.id));
		
		// Collection of Strings
		List<OverridingSortingComparatorInterface> list2 = new ArrayList<>();
		list2.add(new OverridingSortingComparatorInterface("df"));
		list2.add(new OverridingSortingComparatorInterface("a"));
		list2.add(new OverridingSortingComparatorInterface("zdf"));
		list2.add(new OverridingSortingComparatorInterface("ioui"));
		list2.add(new OverridingSortingComparatorInterface("b"));
		
		Collections.sort(list2, c);
		
		list2.stream().forEach(i -> System.out.println(i.getName()));
	}
	
	/*
	 * For Primitives
	 */
	/*
	@Override
	public int compare(OverridingSortingComparatorInterface o1, OverridingSortingComparatorInterface o2) {
		
		// Ascending Order
		return o1.id - o2.id;
		
		// Descending Order
		// return o2.id - o1.id;
	}
	*/
	
	/*
	 * For Objects
	 */
	
	
	@Override
	public int compare(OverridingSortingComparatorInterface o1, OverridingSortingComparatorInterface o2) {
		
		// Ascending Order
		// return o1.name.compareTo(o2.name);
		
		// Descending Order
		return o2.name.compareTo(o1.name);
	}
	
}
