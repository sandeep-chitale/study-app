package com.admin.pharma.misc.ds_algo.cache;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

	private int capacity; // Maximum number of items in the cache.

	public LRUCache(int capacity) {
		super(capacity + 1, 1.0f, true); // Pass 'true' for accessOrder.
		this.capacity = capacity;
	}

	protected boolean removeEldestEntry(Entry entry) {
		return (size() > this.capacity);
	}
}

class Test {
	public static void main(String[] args) {
		LRUCache<String, String> cache=new LRUCache<String, String>(2);
		cache.put("A", "A");
		cache.put("B", "B");
		System.out.println(cache);
		cache.get("A");
		cache.put("C", "C");
		cache.get("A");
		System.out.println(cache);
		
	}
}