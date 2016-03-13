package com.admin.pharma.misc.ds_algo.sort;

public class InsertionSort {
	public static void main(String[] args) {
			int[] arr={5,2,4,6,1,3,0,-100};
			insertionSort(arr);
			
			System.out.println(arr);
	}
	/*
	 * consider arr[0..n-1] and key=1 then we try to place the key at correct position by swapping it with correct elements.
	 * and advance the key
	 */
	public static void insertionSort(int[] arr){
		int temp,key,prev;
		for(int i=1,j=1;i<arr.length;i++){
			key=arr[i];
			prev=j=i;
			while(--j>=0){
				if(key<arr[j]){
					temp=arr[j];
					arr[j]=key;
					arr[i]=temp;
					i=j;
				}else {break;}
			
			}
			i=prev;
		}
	}
}
