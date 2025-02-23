package com.LintCodeContest.Weekly11;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No952_DigitalProblem {

  public static void main(String[] args) {
    No952_DigitalProblem No952_DigitalProblem = new No952_DigitalProblem();
    No952_DigitalProblem.testNo952_DigitalProblem();
  }

  private void testNo952_DigitalProblem() {
    log.info("result 1 v.s. " + digitConvert(2));
    log.info("result 7 v.s. " + digitConvert(3));
  }

  int digitConvert(int n) {
    // filter abnormal cases
    if (n <= 1) {
      return 0;
    }

    int count = 0;
    while (n != 1) {
      if (n % 2 == 1) {
        n = 3 * n + 1;
      } else {
        n = n / 2;
      }
      count++;
    }

    // return the final result
    return count;
  }

}
