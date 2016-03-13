package com.admin.pharma.misc.ds_algo.util;

public class BinarySearch {
	public static void main(String[] args) {
		int [] arr={1,2,3,4,5,6,7};
		int [] arr1={5,6,7,1,2,3,4,4}; //array is rotated so find the pivot/rotation point
		System.out.println(binarySerach(arr,0,arr.length-1,7));
		System.out.println(pivotedBinarySearch(arr1, 3));
	}

	static int pivotedBinarySearch(int[] arr, int num){
		
		//Find the pivot element first
		
		int pivot=findPivot(arr);
		if(pivot==-1) return binarySerach(arr, 0,arr.length-1,num);
		if(arr[pivot]==num) return num;
		if(arr[0]>=num) return binarySerach(arr,pivot+1,arr.length-1,num);
		else return binarySerach(arr, num,0,pivot-1);
		
	}
	private static int findPivot(int[] arr) {
		
		int low=0;
		int high=arr.length-1; int mid=0;
		while(low<=high){
			
			mid=low+(high-low)/2;
			
			if(mid<high&&arr[mid]>arr[mid+1]) return mid;
			if(mid>low&&arr[mid]<arr[mid-1]) return mid-1;
			if(arr[low]>=arr[mid]) high=mid-1;
			else low=mid+1;
		}
		return -1;
		
	}

	private static int binarySerach(int[] arr,int low,int high ,int num) {
	 int mid=0;
		while(low<=high){
			
			mid=low+(high-low)/2;
			
			if(arr[mid]==num) return num;
			
			if(num>arr[mid])
				low=mid+1;
			else
				high=mid-1;
			
		}
		return -1;
	}
}
