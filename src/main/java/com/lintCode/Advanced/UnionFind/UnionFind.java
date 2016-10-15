package com.lintCode.Advanced.UnionFind;

import java.util.HashMap;

/**
 * Created by yanli on 2016-10-14.
 */
public class UnionFind {
    HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();

    public UnionFind(int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int id = convert2Id(i, j, m);
                father.put(id, id);
            }
        }
    }

    public int compressed_find(int key) {
        // find
        int parent = father.get(key);
        while (parent != father.get(parent)) {
            parent = father.get(parent);
        }

        // compress
        int temp = -1;
        int fa = key;
        while (fa != father.get(fa)) {
            temp = father.get(fa);
            father.put(fa, parent);
            fa = temp;
        }
        return parent;

    }

    public boolean union(int key, int keyBigger) {
        int boss = compressed_find(key);
        int bossBigger = compressed_find(keyBigger);
        if (boss != bossBigger) {
            father.put(boss, bossBigger);
            return true;
        }

        return false;
    }

    private int convert2Id(int x, int y, int m) {
        return x * m + y;
    }

    @Override
    public String toString() {
        return "UnionFind{" +
                "father=" + father +
                '}';
    }
}