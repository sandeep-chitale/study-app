package com.admin.pharma.misc.ds_algo.sort;

public class MergeSort {
	public static void main(String[] args) {
		int[] l={1,4,6},r={2,3,5};
		
		for(int i:merge(l,r)){
			System.out.print(i+" ");
		}
		
	}
	public void mergeSort(int[] left,int[] right){
		
	}
	public static int [] merge(int[] left,int[] right){
		int l=0,r=0,i=0;
		
		int[] result=new int[left.length+right.length];
		
		while(l<left.length||r<right.length){
			
			if((l<left.length&&r<right.length)&&left[l]>right[r]){
				result[i++]=right[r];
				r++;
			}else if((l<left.length&&r<right.length)&&left[l]<right[r]){
				result[i++]=left[l];
				l++;
			}else if(l<left.length){
				result[i++]=left[l];
				l++;
			}else if(r<right.length){
				result[i++]=right[r];
				r++;
			}
		}
		return result;
	}
}
