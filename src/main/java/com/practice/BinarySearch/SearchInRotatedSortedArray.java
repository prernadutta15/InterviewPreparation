package com.practice.BinarySearch;

public class SearchInRotatedSortedArray 
{
	//further practice: search in rotated array with duplicates
	public static void main(String[] args) 
	{
//		int arr[]= {8,10,11,13,15,16,18,0,2,3,5}, target = 18;
		int arr[]= {8,9,2,3,4}, target = 9;
		
		//made too many mistakes in this code initially
		
		int index = searchInRotatedArray(arr,target);
		System.out.println(index);
	}
	
	//best way 
	public int search(final int[] a, int b) 
    {
		int l=0,r=a.length-1,mid,pivot=0;
        while(l<=r)
        {
            mid=(l+r)>>1;
            if(a[mid]==b)
                return mid;
            if(a[mid]>=a[l])
            {
                if(b>=a[l] && b<=a[mid])
                r=mid-1;
                else
                l=mid+1;
            }
            else
            {
                if(b>=a[mid] && b<=a[r])
                l=mid+1;
                else
                r=mid-1;
                
            }
        }
       
        return -1;
    }

	//other way
	private static int searchInRotatedArray(int[] a, int target) 
	{
		if(a[0] < a[a.length-1])
			return binarySearch(a,0,a.length-1,target);
		
		int peak = findPeakElement(a);
		
		if(target > a[a.length-1])
			return binarySearch(a, 0, peak, target);
		else
			return binarySearch(a, peak+1, a.length - 1 , target);
		
	}
	
	private static int binarySearch(int[] arr, int start, int end, int target) 
	{
		int mid;
		
		while(start<=end)
		{
			mid = start + (end - start)/2;
			
			if(arr[mid]==target)
			{
				return mid;
			}
			else if(arr[mid]>target)
			{
				end = mid - 1;
			}
			else
				start = mid + 1;
					
		}
		return -1;
	}
	 
	private static int findPeakElement(int[] a) 
	{
		int start = 0, end = a.length - 1 , mid;
		
		while(start<=end) //forgot =
		{
			mid = start + (end - start)/2;
			if(mid+1<a.length && a[mid] > a[mid+1]) //forgot condition
				return mid;
			if(a[mid]>=a[start]) //forgot >= and wrote >
				start = mid + 1;
			else
				end = mid - 1;
		}
		return -1;
	}
}
