package com.practice.BinarySearch;

public class PeakInMountainArray 
{
	public static void main(String[] args) {
		//https://leetcode.com/problems/peak-index-in-a-mountain-array/
		// [ 1,2,3,5,6,4,3,2] suppose mid is at 4, and a[mid]>a[mid+1], it means we are in decreasing part.
		// That is answer may be 4 or in the left part of the array, so binary search is used
		
		int arr[] = {1,2,3,5,6,4,3,2};
		System.out.println("Peak is :" + findPeakOfMountain(arr));
	}

	private static int findPeakOfMountain(int[] arr) 
	{
		int peak = 1; //first element cannot be peak
		int start = 0, end = arr.length - 1, mid;
		while(start <= end)
		{
			mid = start + (end - start)/2;
			if(arr[mid] > arr[mid+1])
			{
				peak = mid;
				end = mid - 1;
			}
			else
				start = mid + 1;
			
		}
		return peak;
	}
}
