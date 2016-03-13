package com.admin.pharma.misc.ds_algo.heap;

public class Heap {
	
	//takes a parent and try to handle violations by exchanging data.
	public static void maxHeapify(Integer[] A,int i){
		int l=2*i+1;
		int r=2*i+2;
		int largest=i;
		//Don't compare leaf nodes
		if(l<A.length&&A[l]>A[i]) largest=l;
		if(r<A.length&&A[r]>A[largest]) largest=r;
		int temp;
		if(largest!=i){
			temp=A[largest];
			A[largest]=A[i];
			A[i]=temp;
			maxHeapify(A, largest);
		}
		
			
	}
	
	public static void buildMaxHeap(Integer[] A){
		for(int i=(A.length-1)/2;i>=0;i--){
			maxHeapify(A, i);
		}
	}
	public static void main(String[] args) {
		Integer[] A={4,1,3,2,16,9,10,14,8,7,56};
	    buildMaxHeap(A);
		for(Integer i:A) System.out.print(i+" ");
		//printHash(8);
		
		
	}
	
	static void printHash(int i){
		
		if(i>1){
			printHash(i/2);
			printHash(i/2);
		}
		System.out.println("@");
	}
	
	static void print(){
		
	
		
		
	}
}
