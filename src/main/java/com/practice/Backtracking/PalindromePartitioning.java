package com.practice.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author prerna.dutta
 *
 */

public class PalindromePartitioning {

	public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> out = new ArrayList<>();
        helper(s,0,s.length(),out,ans);
        return ans;
    }
    void helper(String s, int index, int n, List<String> out, List<List<String>> ans)
    {
        if(index==n)
        {
            ans.add(new ArrayList<>(out));
            return;
        }
        int i;
        for(i=index;i<n;i++)
        {
            if(isPalindrome(s,index,i))
            {
                out.add(s.substring(index,i+1));
                helper(s,i+1,n,out,ans);
                out.remove(out.size()-1);
            }
        }
    }
    boolean isPalindrome(String s, int start, int end)
    {
        while(start<=end)
        {
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
