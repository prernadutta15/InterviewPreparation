package com.practice.Maps;

/**
 * 
 * @author prerna.dutta
 *
 */


class ImplementHashMapBasic {

	    
	    private int[] hash;
	    /** Initialize your data structure here. */
	    public ImplementHashMapBasic() {
	        hash = new int[100001];
	    }
	    
	    /** value will always be non-negative. */
	    public void put(int key, int value) {
	        hash[key] = value + 1;
	    }
	    
	    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
	    public int get(int key) {
	        return hash[key] - 1;
	    }
	    
	    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
	    public void remove(int key) {
	        hash[key] = 0;
	    }
	}