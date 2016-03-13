package com.admin.pharma.misc.design;

import java.util.Calendar;

/*
 *1. Lazily initailized and eagerly 
 */
public class Singleton {

	private static Singleton resource;
	private static volatile boolean initialized;

	// outside no one can instantiate
	private Singleton() {

	}

	public static Singleton getInstance() {
		if (resource == null || !initialized) {
			synchronized (Singleton.class) {
				if (resource == null)
					resource = new Singleton();
			}
			initialized = (resource != null);// ****
		}
		return resource;

	}

	public static void main(String[] args) {

	}
}
