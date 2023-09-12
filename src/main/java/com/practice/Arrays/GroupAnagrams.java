package com.practice.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/group-anagrams/description/
 */
public class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String word: strs){
            char keys[] = new char[26];
            for(int i=0; i<word.length(); i++)
                keys[word.charAt(i) - 'a']++;

            String key = new String(keys);

            if(!map.containsKey(key))
                map.put(key, new ArrayList<>());

            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());
    }
}
