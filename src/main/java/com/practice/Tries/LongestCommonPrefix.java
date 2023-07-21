package com.practice.Tries;

/**
 * 
 * @author prerna.dutta
 *
 */

public class LongestCommonPrefix {

	class Trie
    {
        boolean isEnd;
        int count;
        Trie child[];
        Trie()
        {
            child = new Trie[26];
            isEnd = false;
            count = 0;
        }
    }

    
    Trie insertToTrie(String s, Trie root)
    {
        Trie cur = root;
        for(int i=0;i<s.length();i++)
        {
            if(cur.child[s.charAt(i)-'a'] == null)
            {
                cur.child[s.charAt(i)-'a'] = new Trie();
            }
            cur = cur.child[s.charAt(i)-'a'];
            cur.count = cur.count+1;
        }
        cur.isEnd = true;
        return root;
    }
    public String longestCommonPrefixWay1(String[] A) {
        Trie head = new Trie();
        int i;
        String ans="";
        String out[]=new String[A.length];
        for(i=0;i<A.length;i++)
            head = insertToTrie(A[i],head);
        for(i=0;i<A[0].length();i++)
        {
            head = head.child[A[0].charAt(i)-'a'];
            if(head.count!=A.length)
                break;
            ans = ans+A[0].charAt(i);
        }
        return ans;
    }
    
    
    public String longestCommonPrefixWay2(String[] A) {
             int i,index =0,j;
            String result="";
            for(i=0;i<A[0].length();i++)
            {
                char c = A[0].charAt(i);
                for(j=0;j<A.length;j++)
                {
                    if(i>=A[j].length() || A[j].charAt(i)!=c )
                        return result;
                  
                }
                result = result + c;
            }
            return result;
     }
}
