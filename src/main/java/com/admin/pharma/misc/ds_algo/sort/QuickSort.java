package com.admin.pharma.misc.ds_algo.sort;

public class QuickSort {
	public static void main(String[] args) {
		int arr[] = {5,3,2,1,8,4,6};
		
		quickSort(arr, 0, arr.length-1);
		
		printArray(arr);
		
	}
	/* This function takes last element as pivot, places the pivot element at its
	   correct position in sorted array, and places all smaller (smaller than pivot)
	   to left of pivot and all greater elements to right of pivot */
	static int partition (int[] arr, int l, int h)
	{
	    int x = arr[h];    // pivot
	    int i = (l - 1);  // Index of smaller element
	    //start from low till high
	    for (int j = l; j <= h- 1; j++)
	    {
	        // If current element is smaller than or equal to pivot 
	        if (arr[j] <= x)
	        {
	            i++;    // increment index of smaller element
	            swap(arr,i,j);  // Swap current element with index
	        }
	    }
	    swap(arr,i + 1,h);  
	    return (i + 1);
	}
	static private void swap(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

/* arr[] --> Array to be sorted, l  --> Starting index, h  --> Ending index */
static void quickSort(int arr[], int l, int h)
{
    if (l < h)
    {
        int p = partition(arr, l, h); /* Partitioning index */
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, h);
    }
}
 
/* Function to print an array */
static void printArray(int arr[])
{
    int i;
    for (i=0; i < arr.length; i++)
        System.out.printf("%d ", arr[i]);
    System.out.println();
}
 
}
