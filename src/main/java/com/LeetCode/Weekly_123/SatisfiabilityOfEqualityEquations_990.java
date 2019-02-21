package com.LeetCode.Weekly_123;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working.
 * TIME: O(MN)
 * SPACE: O(MN)
 * <p>
 * Version 2: TBD.
 * TIME: O(?)
 * SPACE: O(?)
 */
public class SatisfiabilityOfEqualityEquations_990 {
    private static final Logger logger = LoggerFactory.getLogger(SatisfiabilityOfEqualityEquations_990.class);

    public static void main(String[] args) {
        SatisfiabilityOfEqualityEquations_990 thisClass = new SatisfiabilityOfEqualityEquations_990();
        thisClass.testArrayForm_989();
    }

    private void testArrayForm_989() {
        logger.info("result {} v.s. {}", "false", equationsPossible(new String[]{"a==b", "b!=a"}));
        logger.info("result {} v.s. {}", "true", equationsPossible(new String[]{"b==a", "a==b"}));
        logger.info("result {} v.s. {}", "true", equationsPossible(new String[]{"a==b", "b==c", "a==c"}));
        logger.info("result {} v.s. {}", "false", equationsPossible(new String[]{"a==b", "b!=c", "c==a"}));
        logger.info("result {} v.s. {}", "true", equationsPossible(new String[]{"c==c", "b==d", "x!=z"}));
    }

    public boolean equationsPossible(String[] equations) {
        // filter abnormal cases
        if (equations == null || equations.length == 0) {
            return true;
        }

        // dp logic
        LinkedList<Integer> listOfNotEquals = new LinkedList<>();
        UnionFind unionFind = new UnionFind();
        for (int i = 0; i < equations.length; i++) {
            String equation = equations[i];
            if (equation.charAt(0) == equation.charAt(3)) {
                if (equation.charAt(1) == '!') {
                    return false;
                }
            } else {
                if (equation.charAt(1) == '!') {
                    listOfNotEquals.add(i);
                } else {
                    unionFind.union(equation.charAt(0), equation.charAt(3));
                }
            }
        }

        for (Integer i : listOfNotEquals) {
            String equation = equations[i];
            if (unionFind.hasSameAncestor(equation.charAt(0), equation.charAt(3))) {
                return false;
            }
        }

        // return the final result
        return true;
    }

    private class UnionFind {
        int[] parent;

        public UnionFind() {
            this.parent = new int[27];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public void union(char a, char b) {
            int kid1 = a - 'a';
            int kid2 = b - 'a';
            int rootA = find(kid1);
            int rootB = find(kid2);
            if (rootA != rootB) {
                parent[rootA] = rootB;
            }
        }

        public int find(int originalKid) {
            int ancestor = originalKid;
            while (parent[ancestor] != ancestor) {
                ancestor = parent[ancestor];
            }
            parent[originalKid] = ancestor;
            return ancestor;
        }

        public char find(char c) {
            int originalKid = c - 'a';
            int current = originalKid;
            while (parent[current] != current) {
                current = parent[current];
            }
            parent[originalKid] = current;
            return (char) (current + 'a');
        }

        public boolean hasSameAncestor(char a, char b) {
            int kid1 = a - 'a';
            int kid2 = b - 'a';
            return find(kid1) == find(kid2);
        }
    }

    private static class MyLogger {
        private static final boolean isDebugging = false;
        private static final boolean isInfoing = true;
        private static final String DEBUG = "[DEBUG]";
        private static final String INFO = "[INFO]";

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println(DEBUG + " = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println(INFO + " = " + message);
            }
        }

        static void debug() {
            if (isDebugging) {
                System.out.println(DEBUG + " = ");
            }
        }

        static void info() {
            if (isInfoing) {
                System.out.println(INFO + " = ");
            }
        }
    }
}
