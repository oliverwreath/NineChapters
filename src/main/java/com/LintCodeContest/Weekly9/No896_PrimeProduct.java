package com.LintCodeContest.Weekly9;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No896_PrimeProduct {

  public static void main(String[] args) {
    No896_PrimeProduct No896_PrimeProduct = new No896_PrimeProduct();
    No896_PrimeProduct.testNo896_PrimeProduct();
  }

  private void testNo896_PrimeProduct() {
    log.info("result [6] v.s. " + Arrays.toString(getPrimeProduct(new int[]{2, 3})));
    log.info("result [6,10,15,30] v.s. " + Arrays.toString(getPrimeProduct(new int[]{2, 3, 5})));
  }

  int[] getPrimeProduct(int[] A) {
    // filter abnormal cases
    if (A == null || A.length == 0) {
      return new int[0];
    }

    this.A = A;
    this.set = new HashSet<>();
    helper(0, 1, 0);

    TreeSet<Integer> treeSet = new TreeSet<>(set);
    int[] answer = new int[treeSet.size()];
    for (int i = 0; i < answer.length; i++) {
      answer[i] = treeSet.pollFirst();
    }

    // return the final result
    return answer;
  }

  private void helper(int index, int product, int counter) {
    if (index == A.length) {
      if (counter > 1) {
        set.add(product);
      }
    } else {
      helper(index + 1, product * A[index], counter + 1);
      helper(index + 1, product, counter);
    }
  }

  int[] A;
  HashSet<Integer> set;

}
