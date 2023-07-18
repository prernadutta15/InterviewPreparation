package com.practice.BinarySearch;

public class FirstAndLastPositionOfElementInSortedArray 
{
	//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
	
	public static void main(String[] args) 
	{
		int arr[] = {1,3,4,7,7,7,7,7,7,8,8,8,8,10};
		int target = 8;
		int position[] = getFirstAndLastPositionOfTarget(arr,target);
		System.out.println(position[0]+"\t"+position[1]);
	}
	private static int getLastPosition(int[] arr, int target) 
	{
		int start = 0, end = arr.length - 1, mid, lastPosition = 0;
		while(start<=end)
		{
			mid = start + (end - start)/2;
			if(arr[mid] == target)
			{
				lastPosition = mid;
				start = mid + 1;
			}
			else if(arr[mid] < target)
			{
				start = mid + 1;
			}
			else
				end = mid - 1;
		}
		
		if(arr[lastPosition] == target) 
			return lastPosition;
		
		return -1;
	}

	private static int getFirstPosition(int[] arr, int target) 
	{
		int start = 0, end = arr.length - 1, mid, firstPosition = 0;
		while(start<=end)
		{
			mid = start + (end - start)/2;
			if(arr[mid] == target)
			{
				firstPosition = mid;
				end = mid - 1;
			}
			else if(arr[mid] > target)
			{
				end = mid - 1;
			}
			else
				start = mid + 1;
		}
		
		if(arr[firstPosition] == target) 
			return firstPosition;
		
		return -1;
	}
	// ####################SMARTER METHOD########################
	
	private static int getFirstAndLastPosition(int[] arr, int target, boolean isFirstPosition) 
	{
		int start = 0, end = arr.length - 1, mid, position = 0;
		while(start<=end)
		{
			mid = start + (end - start)/2;
			if(arr[mid] == target)
			{
				position = mid;
				if(isFirstPosition)
					end = mid - 1;
				else
					start = mid + 1;
			}
			else if(arr[mid] > target)
			{
				end = mid - 1;
			}
			else
				start = mid + 1;
		}
		
		if(arr[position] == target) 
			return position;
		
		return -1;
	}
	
	private static int[] getFirstAndLastPositionOfTarget(int[] arr, int target) 
	{
		int position[] = new int[2];
		if(arr.length == 0)
            return new int[]{-1,-1};
//		position[0] = getFirstPosition(arr,target);
//		position[1] = getLastPosition(arr,target);
		position[0] = getFirstAndLastPosition(arr,target,true);
		position[1] = getFirstAndLastPosition(arr,target,false);
		return position;
	}

}
