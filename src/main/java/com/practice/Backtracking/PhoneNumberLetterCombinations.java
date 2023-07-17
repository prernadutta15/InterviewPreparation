package com.practice.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author prerna.dutta
 *
 */

public class PhoneNumberLetterCombinations {

	public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits.length()==0)return list;
        String word[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        find(0,word,digits,list,"");
        return list;
    }
    void find(int index, String word[], String digits, List<String> list,String ans)
    {
        if(index==digits.length())
        {
            list.add(ans);
            return;
        }
        int j,num=digits.charAt(index)-'0';
        for(j=0;j<word[num].length();j++)
        {
            ans = ans+word[num].charAt(j);
            find(index+1,word,digits,list,ans);
            ans = ans.substring(0,ans.length()-1);
        }
    }
}
