package com.admin.pharma.misc.ds_algo.heap;

public class Pract {
	public static void main(String[] args){
			
		
		System.out.println(16&8);
		
		}
	public static int findPaths(int[][] arr,int m,int n,int count){
		
		if(arr[m-1][n-1]==0) return 0;
		
		if(0 == m && 0 == n){
			count++;
			return count;
		}
		if(n > 0 && arr[m][n-1] != 0){
			count = findPaths(arr,m,n-1,count);
		}
		if(m>0 && arr[m-1][n] != 0){
			count = findPaths(arr,m-1,n,count);
		}
		return count;
	}
	
}
