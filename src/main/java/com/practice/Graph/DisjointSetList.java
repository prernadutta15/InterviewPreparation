package com.practice.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author prerna.dutta
 *
 */

public class DisjointSetList {

    List<Integer> par;
    List<Integer> size;

    DisjointSetList(int V) {
        par = new ArrayList<>();
        size = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            par.add(i);
            size.add(1);
        }
    }

    int findParent(int u) {
        if (u == par.get(u))
            return u;
        par.set(u, findParent(par.get(u)));
        return par.get(u);
    }

    void union(int u, int v) {
        int parU = findParent(u);
        int parV = findParent(v);
        if (parU == parV)
            return;
        if (size.get(parU) < size.get(parV)) {
            par.set(parU, parV);
            size.set(parV, size.get(parV) + size.get(parU));
        } else {
            par.set(parV, parU);
            size.set(parU, size.get(parU) + size.get(parV));
        }
    }

    boolean isConnected(int u, int v) {
        return findParent(u) == findParent(v);
    }
}
