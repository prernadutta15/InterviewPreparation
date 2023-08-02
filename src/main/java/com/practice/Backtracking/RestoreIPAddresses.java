package com.practice.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/restore-ip-addresses/description/
 */
public class RestoreIPAddresses {

	public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if(s.length()>12)return ans;
        helper(s, 0, 0, "", ans);
        return ans;   
    }

    public void helper(String s, int idx, int part, String output, List<String> ans)
    {
        if(idx==s.length() && part==4)
        {
            output = output.substring(0, output.length()-1);
            ans.add(output);
            return;
        }

        if(idx+1<=s.length())
        helper(s,idx+1, part+1, output + s.substring(idx, idx+1)+".", ans);
        if(idx+2<=s.length() && isValid(s.substring(idx, idx+2)))
        helper(s,idx+2, part+1, output + s.substring(idx, idx+2)+".", ans);
        if(idx+3<=s.length() && isValid(s.substring(idx, idx+3)))
        helper(s,idx+3, part+1, output + s.substring(idx, idx+3)+".", ans);
    }

    boolean isValid(String s)
    {
        if(s.charAt(0)=='0')return false;
        if(Integer.parseInt(s)<=255)return true;
        return false;
    }
}
