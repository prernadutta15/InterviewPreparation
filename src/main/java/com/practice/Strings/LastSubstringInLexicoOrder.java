package com.practice.Strings;

import java.util.Arrays;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/last-substring-in-lexicographical-order/description/
 */
public class LastSubstringInLexicoOrder {

	public String lastSubstring(String s) {
        String t = s + "$"; // Append '$' to the end of the input string
        int n = t.length();
        final int alphabet = 256;
        int[] p = new int[n];
        int[] c = new int[n];
        int[] cnt = new int[Math.max(alphabet, n)];
        
        for (int i = 0; i < n; i++) 
        	cnt[t.charAt(i)]++;
        for (int i = 1; i < alphabet; i++) 
        	cnt[i] += cnt[i - 1];
        for (int i = 0; i < n; i++) 
        	p[--cnt[t.charAt(i)]] = i;
        
        c[p[0]] = 0;
        int classes = 1;
        for (int i = 1; i < n; i++) {
            if (t.charAt(p[i]) != t.charAt(p[i - 1])) classes++;
            c[p[i]] = classes - 1;
        }
        
        int[] pn = new int[n];
        int[] cn = new int[n];
        for (int h = 0; (1 << h) < n; ++h) {
            for (int i = 0; i < n; i++) {
                pn[i] = p[i] - (1 << h);
                if (pn[i] < 0) pn[i] += n;
            }
            
            Arrays.fill(cnt, 0, classes, 0);
            for (int i = 0; i < n; i++) cnt[c[pn[i]]]++;
            for (int i = 1; i < classes; i++) cnt[i] += cnt[i - 1];
            for (int i = n - 1; i >= 0; i--) p[--cnt[c[pn[i]]]] = pn[i];
            
            cn[p[0]] = 0;
            classes = 1;
            for (int i = 1; i < n; i++) {
                int cur = c[p[i]] * n + c[(p[i] + (1 << h)) % n];
                int prev = c[p[i - 1]] * n + c[(p[i - 1] + (1 << h)) % n];
                if (cur != prev) ++classes;
                cn[p[i]] = classes - 1;
            }
            
            int[] temp = c;
            c = cn;
            cn = temp;
        }
        
        return t.substring(p[n - 1], t.length()-1);
    }
	public static void main(String[] args) {
		LastSubstringInLexicoOrder ob = new LastSubstringInLexicoOrder();
		System.out.println(ob.lastSubstring("abababab"));
	}
}
