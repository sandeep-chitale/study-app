package com.admin.pharma.misc.collections;

import java.util.*;

/*
 * key -> value in O(1) { array based impln }
 * array[Object]   key --> 5
 * 
 *  array[] ---> buckets , stores the hash value
 *  
 *  {5->{},5000000->{}} : Hashing , basically takes the key and apply hashing algo to get the proper index based on array size
 */
public class HashStudy {

	public static void main(String[] args) {
		Map<String, String> m = new HashMap<String, String>();
		HashSet set;

		m.put("a", "A");
		m.put("b", "B");

		System.out.println(m);

		Map<Customer, Double> cust = new HashMap<Customer, Double>(100, 0.9f);

		Customer c1 = new Customer(20, "ABC");
		Customer c2 = new Customer(20, "ABCD");

		cust.put(c1, new Double(122.0));
		cust.put(c2, new Double(125.0));

		System.out.println(cust);

		System.out.println(cust.get(c1));

		// Key,Val
		// Iterator Key, Entry

		Iterator<Customer> itCust = cust.keySet().iterator();

		while (itCust.hasNext())
			System.out.println(itCust.next());

		Iterator<Map.Entry<Customer, Double>> itE = cust.entrySet().iterator();

	}
}

class Customer implements Comparable<Customer> { // parent class Object
	private int age;
	private String name;

	public Customer(int age, String name) {
		this.age = age;
		this.name = name;
	}

	@Override
	public int hashCode() {

		return name.hashCode()*31 + age*113;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		Customer c = ((Customer) obj);
		if (obj.getClass() == this.getClass()) {
			if (this.age == c.age && this.name.equals(c.name))
				return true;
		}

		return false;
	}

	@Override
	public int compareTo(Customer arg0) {

		return this.name.compareTo(arg0.name);
	}
}

class CustComp implements Comparator<Customer> {
	@Override
	public int compare(Customer o1, Customer o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}