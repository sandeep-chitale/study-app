package com.admin.pharma.misc.ds_algo.algo;

public class ContinousSubArrGivenSum {
	public static void main(String[] args) {
		int[] arr={15, 2, 4, 8, 9, 5, 10, 23};
		
		getAns(arr,23);
	}

	private static void getAns(int[] arr,int sum) {
		
		int ptr=0,curr_sum=arr[0];
		for(int i=1;i<arr.length;i++){
				
			curr_sum+=arr[i];
			if(curr_sum==sum) System.out.println(""+ptr+" "+i);
			
			while(curr_sum>sum){
				curr_sum-=arr[ptr++];
			}
			
			
		}
		
	}

}
