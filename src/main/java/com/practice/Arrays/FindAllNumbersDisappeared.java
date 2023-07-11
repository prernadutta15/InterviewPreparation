package com.practice.Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author prerna.dutta
 *
 */

public class FindAllNumbersDisappeared {

	 public List<Integer> findDisappearedNumbers(int[] a) {
	        Set<Integer> set = new HashSet<>();
	        int i,n=a.length,k=0;
	        List<Integer> out=new ArrayList<Integer>();
	        for(i=0;i<n;i++)
	        {
	            set.add(a[i]);
	        }
	        for(i=1;i<=n;i++)
	        {
	            if(set.contains(i)==false)
	                out.add(i);
	        }
	        return out;

	    }
}
