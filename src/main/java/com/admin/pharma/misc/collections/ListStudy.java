package com.admin.pharma.misc.collections;

import java.util.*;

/*
 * ArrayList: uses underlying array , contigous memory allocation, accesss data by its index, arr[5] --> O(1)
 * Vector: Its synchronized arrayList: one thread can acces a list at a time
 * LinkedList: data is stored in list node fashion and its not continuos array, random access is O(n)  
 * 
 * All not concurrent iterators implementations are faileFast and concurrent DS is FailSafe
 */
public class ListStudy {
	public static void main(String[] args) {
		// Generic : It provides me a compile time safety
		int size = 50;
		//List<String> arrList = new LinkedList<String>();
		List<String> arrList = new ArrayList<String>();
		long st = System.currentTimeMillis();
		for (int i = 0; i < size; i++) {
			arrList.add(i+"");
		}
		System.out.println((System.currentTimeMillis() - st) );

		st = System.currentTimeMillis();
		// Iterator is will be used internally
		for (String s : arrList) {
			//System.out.println(s);
			s="TEST";
		}
		
		ListIterator<String> it=arrList.listIterator();
		//arrList.remove(5);
		while(it.hasNext()) {
			System.out.println(it.next());
			it.add("55"); 
			arrList.add("66");
		}
		
		System.out.println((System.currentTimeMillis() - st) );
		
		List<T> l1=new ArrayList<T>();
		
		
		
		addEl(l1);
	}
	
	public static void addEl(List<? super B> l){
		
	}
}

interface T {
	
}

class A implements T{
	
}

class B extends A{
	
}

class C extends B{
	
}