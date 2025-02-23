package com.LintCodeContest.Weekly8;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No842_Origami {

  public static void main(String[] args) {
    No842_Origami No842_Origami = new No842_Origami();
    No842_Origami.testNo842_Origami();
  }

  private void testNo842_Origami() {
    log.info("result 0 v.s. " + getString(1));
    log.info("result 001 v.s. " + getString(2));
    log.info("result 0010011 v.s. " + getString(3));
  }

  String getString(int n) {
    // filter abnormal cases
    if (n <= 0) {
      return "";
    }

    this.answer = new StringBuilder();
    this.n = n;
    dfs(1, 0);

    // return the final result
    return answer.toString();
  }

  StringBuilder answer;
  int n;

  void dfs(int height, int index) {
    if (height + 1 <= n) {
      dfs(height + 1, index * 2);
    }
    this.answer.append((index % 2 == 0) ? '0' : '1');
    if (height + 1 <= n) {
      dfs(height + 1, index * 2 + 1);
    }
  }

}
