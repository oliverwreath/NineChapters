# 算法模板

## Table of Contents

- [Introduction](#Introduction)
- [九章算法班](#九章算法班)
- [强化班](#强化班)

## Introduction

算法模板好像人体的骨骼，智商就像肌肉。没有背好模板就是缺钙。

## 九章算法班

- [Ch2 - Binary_Search](#Ch2-Binary-Search)
- [Ch3 - 为面试而生的双指针算法 Two Pointers Algorithm](#Ch3-为面试而生的双指针算法-Two-Pointers-Algorithm)
- [Ch4 - 宽度优先搜索和拓扑排序 BFS & Topological Sorting](#Ch4-宽度优先搜索和拓扑排序-BFS-&-Topological-Sorting)
- [Ch5 - 基于树的深度优先搜索 Tree-based DFS](#Ch5-基于树的深度优先搜索-Tree-based-DFS)
- [Ch6 - 基于组合的深度优先搜索 Combination-based DFS](#Ch6-基于组合的深度优先搜索-Combination-based-DFS)
- [Ch7 - 基于排列、图的深度优先搜索 Permutation / Graph based DFS](#Ch7-基于排列、图的深度优先搜索-Permutation-/-Graphbased-DFS)
- [Ch8 - 数据结构 - 栈，队列，哈希表与堆 Stack, Queue, Hash & Heap](#Ch8-数据结构---栈，队列，哈希表与堆-Stack,-Queue,-Hash-&-Heap)
- [Ch9 - 数据结构 - 区间、数组、矩阵与树状数组 Interval, Array, Matrix & Binary Indexed Tree](#Ch9-数据结构---区间、数组、矩阵与树状数组-Interval,-Array,-Matrix-&-BinaryIndexedTree)

### Ch2 Binary Search

模板

        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }

##### Other Bullshit

• 基本的二分法该如何写
• 第一个位置，最后一个位置该如何变化
• Big O，时间复杂度，空间复杂度
• 什么是递归，二分法用递归如何实现
• 内存中的栈空间和堆空间有什么区别
• 什么是 Stack Overflow，什么情况下会造成 Stack Overflow

### Ch3 为面试而生的双指针算法 Two Pointers Algorithm

### Ch4 宽度优先搜索和拓扑排序 BFS & Topological Sorting

### Ch5 基于树的深度优先搜索 Tree-based DFS

### Ch6 基于组合的深度优先搜索 Combination-based DFS

### Ch7 基于排列、图的深度优先搜索 Permutation / Graphbased DFS

### Ch8 数据结构 - 栈，队列，哈希表与堆 Stack, Queue, Hash & Heap

### Ch9 数据结构 - 区间、数组、矩阵与树状数组 Interval, Array, Matrix & BinaryIndexedTree

## 强化班

- [Ch1](#强化班)
- [Ch2 - 数据结构(上)之并查集与字典树](#Ch2-数据结构(上)之并查集与字典树)
- [Ch3 - 数据结构(下)之堆与栈难题精讲](#Ch3-数据结构(下)之堆与栈难题精讲)
- [Ch4 - 二分法 和 扫描线](#Ch4-二分法-和-扫描线)
- [Ch5 - 动态规划(上) - 滚动数组与记忆化搜索，区间型](#Ch5-动态规划(上)---滚动数组与记忆化搜索，区间型)
- [Ch6 - 动态规划(下) - 双序列与背包](#Ch6-动态规划(下)---双序列与背包)
- [Ch7 - 如何解决 follow up 问题](#Ch7-如何解决-follow-up-问题)

### Ch2 数据结构(上)之并查集与字典树

### Ch3 数据结构(下)之堆与栈难题精讲

### Ch4 二分法 和 扫描线

### Ch5 动态规划(上) - 滚动数组与记忆化搜索，区间型

### Ch6 动态规划(下) - 双序列与背包

### Ch7 如何解决 follow up 问题
