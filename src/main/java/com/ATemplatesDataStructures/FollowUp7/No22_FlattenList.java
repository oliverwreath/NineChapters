package com.ATemplatesDataStructures.FollowUp7;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class No22_FlattenList {
  public static void main(String[] args) {
    No22_FlattenList No22_FlattenList = new No22_FlattenList();
    No22_FlattenList.testNo22_FlattenList();
  }

  private void testNo22_FlattenList() {
    List<NestedInteger> nestedList = new LinkedList<>();
    nestedList.add(new NestedInt(false, new int[]{1, 1}));
    nestedList.add(new NestedInt(true, 2));
    nestedList.add(new NestedInt(false, new int[]{1, 1}));
    log.debug("nestedList = " + nestedList);
    log.info("result [1,1,2,1,1] v.s. " + flatten(nestedList));
    nestedList.clear();
    nestedList.add(new NestedInt(true, 1));
    nestedList.add(new NestedInt(true, 2));
    nestedList.add(new NestedInt(false, new int[]{1, 2}));
    log.info("result [1,2,1,2] v.s. " + flatten(nestedList));
  }

  public class NestedInt implements NestedInteger {
    boolean isInteger;
    Integer integer;
    List<NestedInteger> list;

    public NestedInt(boolean isInteger, Integer integer) {
      this.isInteger = isInteger;
      this.integer = integer;
    }

    public NestedInt(boolean isInteger, List<NestedInteger> list) {
      this.isInteger = isInteger;
      this.list = list;
    }

    public NestedInt(boolean isInteger, int[] array) {
      this.isInteger = isInteger;
      List<NestedInteger> list = new LinkedList<>();
      for (int i : array) {
        list.add(new NestedInt(true, i));
      }
      this.list = list;
    }

    @Override
    public boolean isInteger() {
      return this.isInteger;
    }

    @Override
    public Integer getInteger() {
      return this.integer;
    }

    @Override
    public List<NestedInteger> getList() {
      return this.list;
    }

    @Override
    public String toString() {
      if (isInteger) {
        return "{" +
                "" + integer +
                '}';
      } else {
        return "{" +
                "" + list +
                '}';
      }
    }
  }

  public interface NestedInteger {
    // @return true if this NestedInteger holds a single integer,
    // rather than a nested combinations.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds,
    // if it holds a single integer
    // Return null if this NestedInteger holds a nested combinations
    public Integer getInteger();

    // @return the nested combinations that this NestedInteger holds,
    // if it holds a nested combinations
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
  }

//    public List<Integer> flatten(List<NestedInteger> nestedList) {
//        // filter abnormal cases
//        List<Integer> answers = new ArrayList<>();
//        if (nestedList == null || nestedList.size() == 0) {
//            return answers;
//        }
//
//
//        for (NestedInteger nestedInteger : nestedList) {
//            if (nestedInteger.isInteger()) {
//                answers.add(nestedInteger.getInteger());
//            } else {
//                Deque<NestedInteger> stack = new ArrayDeque<>();
//                stack.addAll(nestedInteger.getList());
//                List<Integer> tmpReverseList = new ArrayList<>();
//                while (!stack.isEmpty()) {
//                    NestedInteger node = stack.pop();
//                    if (node.isInteger()) {
//                        tmpReverseList.add(node.getInteger());
//                    } else {
//                        stack.addAll(node.getList());
//                    }
//                }
//                Collections.reverse(tmpReverseList);
//                answers.addAll(tmpReverseList);
//            }
//        }
//
//        // return the final result
//        return answers;
//    }

  public List<Integer> flatten(List<NestedInteger> nestedList) {
    // filter abnormal cases
    List<Integer> answers = new ArrayList<>();
    if (nestedList == null || nestedList.size() == 0) {
      return answers;
    }

    for (NestedInteger nestedInteger : nestedList) {
      if (nestedInteger.isInteger()) {
        answers.add(nestedInteger.getInteger());
      } else {
        answers.addAll(flatten(nestedInteger.getList()));
      }
    }

    // return the final result
    return answers;
  }

}
