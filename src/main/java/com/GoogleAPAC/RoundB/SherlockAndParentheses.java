package com.GoogleAPAC.RoundB;

import static com.GoogleAPAC.RoundA.Util.getPrintWriter;

import java.io.PrintWriter;
import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class SherlockAndParentheses {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
//        testGetResult();
    SherlockAndParentheses();
    log.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
  }

  public static void SherlockAndParentheses() {
    Scanner scanner = new Scanner(System.in);
    int numOfCases;
    if (scanner.hasNext()) {
      numOfCases = scanner.nextInt();
      PrintWriter printWriter = getPrintWriter(
          "C:\\Users\\yanli\\IdeaProjects\\JiuZhang\\src\\main\\resources\\SherlockAndParentheses.out.txt");

      for (int caseI = 1; caseI <= numOfCases; caseI++) {
        int left = scanner.nextInt();
        int right = scanner.nextInt();
        int min = Math.min(left, right);
        String result = "Case #" + caseI + ": " + getResult(min);
//                log.debug(result);
        printWriter.println(result);
      }

      printWriter.flush();
    }
  }

  public static void testGetResult() {
    for (int i = 0; i < 10; i++) {
      log.debug(i + ": " + getResult(i));
    }
  }

  public static int getResult(int n) {
    int ret = 0;
    for (int i = 1; i <= n; i++) {
      ret += i;
    }
    return ret;
  }
}
