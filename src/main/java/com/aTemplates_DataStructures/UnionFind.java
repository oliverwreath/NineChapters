package com.aTemplates_DataStructures;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by yanli on 2016-10-14.
 */
public class UnionFind {
    private HashMap<Integer, Integer> father;

    public UnionFind() {
        father = new HashMap<>();
    }

    public UnionFind(HashSet<Integer> set) {
        for (Integer current : set) {
            father.put(current, current);
        }
    }

    public UnionFind(int n) {
        for (int i = 1; i <= n; i++) {
            father.put(i, i);
        }
    }

    /**
     * 2d matrix
     *
     * @param n
     * @param m
     */
    public UnionFind(int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int id = convert2Id(i, j, m);
                father.put(id, id);
            }
        }
    }

    private int convert2Id(int i, int j, int m) {
        return i * m + j;
    }

    /**
     * NON_compressed_find
     *
     * @param key
     * @return
     */
    public int find_NotCompressed(int key) {
        while (father.get(key) != key) {
            key = father.get(key);
        }
        return key;
    }

    /**
     * Compressed_find
     *
     * @param key
     * @return
     */
    public int find(int key) {
        // is root itself
        if (father.get(key) == key) {
            return key;
        }

        // not root itself
        father.put(key, find(father.get(key)));
        return father.get(key);
    }

    public void union(int key, int keyBigger) {
        int boss = find(key);
        int bossBigger = find(keyBigger);
        if (boss != bossBigger) {
            father.put(boss, bossBigger);
        }
    }

    @Override
    public String toString() {
        return "UnionFind{" +
                "father=" + father +
                '}';
    }
}