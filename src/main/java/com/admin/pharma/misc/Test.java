package com.admin.pharma.misc;

public class Test {
	public static void main(String[] args) {
		try {
		Class t=	Class.forName("Customer");
		
		System.out.println(t.getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


class Customer{
	
}