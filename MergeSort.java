package com.jagadish.ds;// Java program for Merge Sort

class MergeSort { 
	// Merges two subarrays of arr[]. 
	// First subarray is arr[l..m] 
	// Second subarray is arr[m+1..r] 
	int[] merge(int arr[], int l, int m, int r) 
	{ 
		int p1=l;
		int p2=m+1;
		int p3=0;
		int temp[] = new int[r-l+1];
		/*It compares the elements from both subarrays 
		and merges them into a temporary array (temp) in sorted order. */
		while(p1<=m && p2<=r){
			if(arr[p1] < arr[p2]){
				temp[p3++] = arr[p1++];
			}else{
				temp[p3++] = arr[p2++];
			}
		}
		//copy remaining elements
		while(p1 <= m){
			temp[p3++] = arr[p1++];
		}
		while(p2 <= r){
			temp[p3++] = arr[p2++];
		}
		/*Finally, it copies the elements from the temporary array back into the original array (arr) */
		p1=0;
		int k=l;
		while(p1<temp.length){
			arr[k++] = temp[p1++];
		}
		return arr;
	} 

	// Main function that sorts arr[l..r]
	void sort(int arr[], int l, int r) 
	{ 
		if (l < r) { 
			// Find the middle point 
			int m = (l + r) / 2; 

			sort(arr, l, m); //sort first half
			sort(arr, m + 1, r); //sort second half

			// Merge the sorted halves 
			merge(arr, l, m, r); 
		} 
	} 

	// A utility function to print array of size n 
	static void printArray(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i = 0; i < n; ++i) 
			System.out.print(arr[i] + " "); 
		System.out.println(); 
	} 

  //main function
	public static void main(String args[]) 
	{ 
		int arr[] = { 53, 13, 43, 10}; 

		System.out.println("Input Array"); 
		printArray(arr); 

		// Merge Sort call
		MergeSort mergeSort = new MergeSort();
		mergeSort.sort(arr, 0, arr.length - 1);

		System.out.println("\nSorted array"); 
		printArray(arr); 
	} 
}
