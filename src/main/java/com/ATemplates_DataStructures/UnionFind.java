package com.ATemplates_DataStructures;

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
     * @param m
     * @param n
     */
    public UnionFind(int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int id = convert2Id(i, j, n);
                father.put(id, id);
            }
        }
    }

    public int convert2Id(int i, int j, int n) {
        return i * n + j;
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

    public void addNew(int key) {
        father.put(key, key);
    }

    /**
     * find root
     *
     * @param a
     * @return
     */
    public int find(int a) {
        // is root itself
        if (father.get(a) == a) {
            return a;
        }

        // not root itself
        father.put(a, find(father.get(a)));
        return father.get(a);
    }

    /**
     * @param a
     * @param b
     */
    public void union(int a, int b) {
        father.put(find(a), find(b));
    }

    /**
     * isConnected
     *
     * @param a
     * @param b
     * @return
     */
    public boolean query(int a, int b) {
        // write your code here
        return find(a) == find(b);
    }

    public boolean union_Number_Of_Island2(int key, int keyBigger) {
        int boss = find(key);
        int bossBigger = find(keyBigger);
        if (boss != bossBigger) {
            father.put(boss, bossBigger);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "UnionFind{" +
                "father=" + father +
                '}';
    }
}