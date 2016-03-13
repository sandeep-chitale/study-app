package com.admin.pharma.misc.ds_algo.sort;

public class KthSmallest {
	public static void main(String[] args) {
        
		int[] arr={10,5,3,4,8,1,9,7};
		//System.out.println(partition(arr, 0, arr.length-1));
		printArray(arr);
		System.out.println(kthSmallestElement(arr, 0, arr.length-1, 3));
	}
	public static int kthSmallestElement(int[] arr,int l,int r,int k){
		
		if(k>0){
			int pos=partition(arr, l, r);
			
			 if(pos==k) return arr[pos];
			 
			 if(pos>k) return kthSmallestElement(arr, l, pos-1, k);
			 else{
				 return kthSmallestElement(arr, pos+1, r, k);
			 }
		}
		
		return -1;
		
	}
	static int partition(int[] arr, int l, int r) {

		int i = l; // Index of smaller element
		// start from low till high
		for (int j = l; j <= r - 1; j++) {
			// If current element is smaller than or equal to pivot
			if (arr[j] <= arr[r]) {
				swap(arr, i, j); // Swap current element with index
				i++; // increment index of smaller element
			}
		}
		swap(arr, i, r);
		return i;
	}

	static private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	/* Function to print an array */
	static void printArray(int arr[]) {
		int i;
		for (i = 0; i < arr.length; i++)
			System.out.printf("%d ", arr[i]);
		System.out.println();
	}
}
